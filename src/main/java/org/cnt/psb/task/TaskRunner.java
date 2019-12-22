package org.cnt.psb.task;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author lixinjie
 * @since 2019-11-07
 */
//@Component
public class TaskRunner implements ApplicationRunner {

	@Autowired
	private SlowExecute slowExecute;
	
	@Autowired
	private TaskExecute taskExecute;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		printThreadInfo("开始");
		//slowExe();
		taskExe();
		printThreadInfo("结束");
	}
	
	void taskExe() throws Exception {
		Object value1 = "task1";
		taskExecute.task1(value1);
		
		Object value2 = "task2";
		Future<Object> future = taskExecute.task2(value2);
		System.out.println(future);
		while (!future.isDone()) {
			printThreadInfo("任务尚未完成，睡眠等待2秒");
			TimeUnit.SECONDS.sleep(2);
		}
		printThreadInfo("任务结果：" + future.get());
		
		Object value3 = "task3";
		ListenableFuture<Object> listenableFuture = taskExecute.task3(value3);
		System.out.println(listenableFuture);
		listenableFuture.addCallback(
				result -> {printThreadInfo1("任务结果：" + result);},
				ex -> {}
		);
		
		Object value4 = "task4";
		CompletableFuture<Object> completableFuture = taskExecute.task4(value4);
		System.out.println(completableFuture);
		completableFuture.thenApply(result -> {
			printThreadInfo("任务结果：" + result);
			return result;
		});
	}
	
	void slowExe() {
		Object value1 = "task1";
		slowExecute.task1(value1);
		Object value2 = "task2";
		slowExecute.task2(value2);
	}

	private void printThreadInfo(String info) {
		System.out.println(LocalTime.now().toString() + "，" + info
							+ "，主线程ID：" + Thread.currentThread().getId()
							+ "，主线程Name：" + Thread.currentThread().getName());
	}
	
	private void printThreadInfo1(String info) {
		System.out.println(LocalTime.now().toString() + "，" + info
				+ "，任务线程ID：" + Thread.currentThread().getId()
				+ "，任务线程Name：" + Thread.currentThread().getName());
	}
}

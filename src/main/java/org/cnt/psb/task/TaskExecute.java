package org.cnt.psb.task;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author lixinjie
 * @since 2019-11-07
 */
@Component
public class TaskExecute {

	@Async
	public void task1(Object value) {
		try {
			printSleepInfo();
			TimeUnit.SECONDS.sleep(5);
		} catch (Throwable ex) {
			
		}
		printValueInfo(value);
	}
	
	@Async
	public Future<Object> task2(Object value) {
		try {
			printSleepInfo();
			TimeUnit.SECONDS.sleep(5);
			return AsyncResult.forValue(value);
		} catch (Throwable ex) {
			return AsyncResult.forExecutionException(ex);
		}
	}
	
	@Async
	public ListenableFuture<Object> task3(Object value) {
		try {
			printSleepInfo();
			TimeUnit.SECONDS.sleep(5);
			return AsyncResult.forValue(value);
		} catch (Throwable ex) {
			return AsyncResult.forExecutionException(ex);
		}
	}
	
	@Async
	public CompletableFuture<Object> task4(Object value) {
		try {
			printSleepInfo();
			TimeUnit.SECONDS.sleep(5);
			return AsyncResult.forValue(value).completable();
		} catch (Throwable ex) {
			return AsyncResult.forExecutionException(ex).completable();
		}
	}
	
	private void printSleepInfo() {
		System.out.println(LocalTime.now().toString()
							+ "，任务线程ID：" + Thread.currentThread().getId()
							+ "，任务线程Name：" + Thread.currentThread().getName()
							+ "，睡眠5秒");
	}
	
	private void printValueInfo(Object value) {
		System.out.println(LocalTime.now().toString()
				+ "，Value：" + value);
	}
}

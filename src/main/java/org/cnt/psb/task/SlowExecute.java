package org.cnt.psb.task;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-11-07
 */
@Component
public class SlowExecute {

	public void task1(Object value) {
		try {
			printSleepInfo();
			TimeUnit.SECONDS.sleep(5);
		} catch (Throwable ex) {
			
		}
		printValueInfo(value);
	}
	
	public Object task2(Object value) {
		try {
			printSleepInfo();
			TimeUnit.SECONDS.sleep(5);
		} catch (Throwable ex) {
			
		}
		printValueInfo(value);
		return value;
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

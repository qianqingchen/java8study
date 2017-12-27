package com.study.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class CountDownLatchDemo {
	private static CountDownLatch countDownLatch = new CountDownLatch(5);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> countDown()).start();
		}
		System.out.println("主线程等待执行");
		countDownLatch.await();
		System.out.println(System.currentTimeMillis() + "  主线程执行");
	}

	public static void countDown() {
		// 让所有线程都park5s钟
		LockSupport.parkNanos(5000000000L);
		countDownLatch.countDown();
		System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getName() + "线程执行");
	}
}

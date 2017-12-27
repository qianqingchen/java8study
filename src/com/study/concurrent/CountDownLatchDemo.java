package com.study.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class CountDownLatchDemo {
	private static CountDownLatch countDownLatch = new CountDownLatch(5);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> countDown()).start();
		}
		System.out.println("���̵߳ȴ�ִ��");
		countDownLatch.await();
		System.out.println(System.currentTimeMillis() + "  ���߳�ִ��");
	}

	public static void countDown() {
		// �������̶߳�park5s��
		LockSupport.parkNanos(5000000000L);
		countDownLatch.countDown();
		System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getName() + "�߳�ִ��");
	}
}

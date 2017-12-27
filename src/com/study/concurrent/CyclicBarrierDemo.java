package com.study.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.LockSupport;

public class CyclicBarrierDemo {
	private static CyclicBarrier cyclicBarrier = new  CyclicBarrier(5);
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> run()).start();
		}
	}
	
	public static void run() {
		try {
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName() + "线程等待结束");
			//让所有线程都park5s钟
			LockSupport.parkNanos(5000000000L);
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getName() + "线程执行");
	}
}

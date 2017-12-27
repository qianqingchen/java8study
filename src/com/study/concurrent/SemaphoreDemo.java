package com.study.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	private static Semaphore semaphore = new Semaphore(0);
	
	public static void main(String[] args) {
		new Thread(() -> run()).start();
		new Thread(() -> run()).start();
		new Thread(() -> run()).start();
		new Thread(() -> run()).start();
		new Thread(() -> run()).start();
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore.release(5);
	}
	
	
	public static void run() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getName() + "œﬂ≥Ã÷¥––");
	}

}

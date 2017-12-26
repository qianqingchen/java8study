package com.study.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 利用LockSupport.park和unpark实现线程的唤醒和等待
 *
 */
public class ParkTest {
	private static Object object;

	public static void main(String[] args) throws InterruptedException {
		
		// Thread a = new Thread(() -> park());
		// object = a;
		// a.start();
		// unpark(true);

		/**
		 * 先调用unpark，再调用park，结果为仍然可以实现同步
		 */
		// object = Thread.currentThread();
		// new Thread(() -> unpark(false)).start();
		// try {
		// // 主线程睡眠3s
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// park();

		/**
		 * 测试线程中断响应，线程中断响应之后，仍然被唤醒
		 */
		object = Thread.currentThread();
		Thread a = new Thread(() -> park());
		a.start();
		try {
			// 主线程睡眠3s
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.interrupt();

	}

	/**
	 * 线程睡眠多少纳秒自动唤醒
	 *
	 */
	public static void parkNanos(Long l) {
		LockSupport.parkNanos("parkNanos", l * 1000000000);
	}

	/**
	 * 线程等待
	 */
	public static void park() {
		System.out.println(Thread.currentThread().getName() + "线程等待");
		System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
		LockSupport.park(object);
		System.out.println(Thread.currentThread().getName() + "线程被唤醒");
	}

	/**
	 * 唤醒线程
	 */
	public static void unpark(boolean flag) {
		if (flag) {
			try {
				// 主线程睡眠3s
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "唤醒线程");
		// 获取blocker
		System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
		LockSupport.unpark((Thread) object);
	}
}

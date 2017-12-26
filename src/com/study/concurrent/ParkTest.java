package com.study.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * ����LockSupport.park��unparkʵ���̵߳Ļ��Ѻ͵ȴ�
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
		 * �ȵ���unpark���ٵ���park�����Ϊ��Ȼ����ʵ��ͬ��
		 */
		// object = Thread.currentThread();
		// new Thread(() -> unpark(false)).start();
		// try {
		// // ���߳�˯��3s
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// park();

		/**
		 * �����߳��ж���Ӧ���߳��ж���Ӧ֮����Ȼ������
		 */
		object = Thread.currentThread();
		Thread a = new Thread(() -> park());
		a.start();
		try {
			// ���߳�˯��3s
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.interrupt();

	}

	/**
	 * �߳�˯�߶��������Զ�����
	 *
	 */
	public static void parkNanos(Long l) {
		LockSupport.parkNanos("parkNanos", l * 1000000000);
	}

	/**
	 * �̵߳ȴ�
	 */
	public static void park() {
		System.out.println(Thread.currentThread().getName() + "�̵߳ȴ�");
		System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
		LockSupport.park(object);
		System.out.println(Thread.currentThread().getName() + "�̱߳�����");
	}

	/**
	 * �����߳�
	 */
	public static void unpark(boolean flag) {
		if (flag) {
			try {
				// ���߳�˯��3s
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "�����߳�");
		// ��ȡblocker
		System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
		LockSupport.unpark((Thread) object);
	}
}

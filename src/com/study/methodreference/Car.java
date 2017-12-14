package com.study.methodreference;

import java.util.function.Supplier;

/**
 * ��������ʹ�ÿ����߿���ֱ�������ִ�ķ�����Java��Ĺ��췽������ʵ�����󡣷������ú�Lambda���ʽ���ʹ�ã�ʹ��java��Ĺ��췽�����������ն���࣬û�кܶิ�ӵ�ģ����롣
 * 
 * ���ŵ������У�Car���ǲ�ͬ�������õ����ӣ����԰������������������͵ķ������á�
 * 
 * @author Administrator
 *
 */
public class Car {
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
}

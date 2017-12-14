package com.study.methodreference;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		final Car car = Car.create( Car::new );
		final List< Car > cars = Arrays.asList( car );
		//���õ������Ǿ�̬�������ã��﷨��Class::static_method��ע�⣺�����������һ��Car���͵Ĳ�����
		cars.forEach( Car::collide );
		//���õ�������ĳ����ĳ�Ա���������ã��﷨��Class::method��ע�⣬�������û�ж�����Σ�
		cars.forEach( Car::repair );
		//���õ�������ĳ��ʵ������ĳ�Ա���������ã��﷨��instance::method��ע�⣺�����������һ��Car���͵Ĳ�����
		final Car police = Car.create( Car::new );
		cars.forEach( police::follow );
	}
}

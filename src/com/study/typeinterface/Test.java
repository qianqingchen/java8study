package com.study.typeinterface;

public class Test {
	public static void main(String[] args) {
		//���д�����Value<String>���͵�Ӧ��
		final Value<String> value = new Value<>();
		System.out.println(value.getOrDefault("22", Value.defaultValue()));
	}
}

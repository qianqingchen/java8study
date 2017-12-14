package com.study.typeinterface;

public class Test {
	public static void main(String[] args) {
		//下列代码是Value<String>类型的应用
		final Value<String> value = new Value<>();
		System.out.println(value.getOrDefault("22", Value.defaultValue()));
	}
}

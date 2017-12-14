package com.study.functionalinterface;

public class Test {
	
	public static void main(String[] args) {
		copyOutMethod(() -> System.out.println("method run"));
	}

	public static void copyOutMethod(FunctionalDefaultMethods fdm) {
		fdm.method();
	}
}

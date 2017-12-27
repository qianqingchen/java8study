package com.study.outofmemory;

/**
 * VM Args: -Xss128k
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	private void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stackLength:" + oom.stackLength);
			throw e;
		}
	}
}

/**
 * stackLength:984 Exception in thread "main" java.lang.StackOverflowError at
 * com.study.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:11) at
 * com.study.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12) at
 * com.study.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12) at
 * com.study.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12)
 **/
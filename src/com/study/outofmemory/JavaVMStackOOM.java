package com.study.outofmemory;

/**
 * VM Args: -Xss2m
 */
public class JavaVMStackOOM {
	
	private void dontStop() {
		while(true) {
			
		}
	}
	
	public void stackLeakByThread() {
		while(true) {
			new Thread(() -> dontStop()).start();;
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
		javaVMStackOOM.stackLeakByThread();
	}
}

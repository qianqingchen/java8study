package com.study.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 实现运行时常量池的内存溢出，此类在JDK1.7之后不会出现内存溢出的情况
 */
public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}

package com.study.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * ʵ������ʱ�����ص��ڴ����
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

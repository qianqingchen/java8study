package com.study.functionalinterface;

/**
 * Lambda���������Ϊ�������еĹ�����Lambda���ʽ���ü��ݣ������˺ܶ෽�������ǲ����˺����ӿ�������
 * �����ӿ�ָ����ֻ��һ�������Ľӿڣ������Ľӿڿ�����ʽת��ΪLambda���ʽ��java.lang.Runnable��java.util.concurrent.Callable�Ǻ���ʽ�ӿڵ�������ӡ�
 * ��ʵ���У�����ʽ�ӿڷǳ�������ֻҪĳ���������ڸýӿ������һ����������ýӿھͲ����Ǻ���ʽ�ӿڽ������±���ʧ�ܡ�
 * Ϊ�˿˷����ִ������Ĵ����ԣ�����ʽ˵��ĳ���ӿ��Ǻ���ʽ�ӿڣ�Java8 �ṩ��һ�������ע��@FunctionalInterface��Java
 * ���е�������ؽӿڶ��Ѿ��������ע���ˣ����ٸ��򵥵ĺ���ʽ�ӿڵĶ��壺
 * 
 * @author Administrator
 *
 */
@FunctionalInterface
public interface FunctionalDefaultMethods extends Functional {
	void method();

	default void defaultMethod() {
	}
}

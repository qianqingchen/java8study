package com.study.packinterface;

/**
 * Defaulable�ӿ�ʹ�ùؼ���default������һ��Ĭ�Ϸ���notRequired()��
 * DefaultableImpl��ʵ��������ӿڣ�ͬʱĬ�ϼ̳�������ӿ��е�Ĭ�Ϸ�����
 * OverridableImpl��Ҳʵ��������ӿڣ�����д�˸ýӿڵ�Ĭ�Ϸ��������ṩ��һ����ͬ��ʵ�֡�
 * @author Administrator
 *
 */
public class OverridableImpl implements Defaulable {
	@Override
	public String notRequired() {
		return "Overridden implementation";
	}
	public void say() {
		System.out.println("hello world");
	}
}
package com.study.packinterface;

/**
 * Java 8ʹ�������¸�����չ�˽ӿڵĺ��壺Ĭ�Ϸ����;�̬������Ĭ�Ϸ���ʹ�ýӿ��е�����traits������Ҫʵ�ֵ�Ŀ�겻һ����Ĭ�Ϸ���ʹ�ÿ����߿�����
 * ���ƻ������Ƽ����Ե�ǰ���£����ִ�ӿ�������µķ���������ǿ����Щʵ���˸ýӿڵ���Ҳͬʱʵ������¼ӵķ�����
 * 
 * Ĭ�Ϸ����ͳ��󷽷�֮����������ڳ��󷽷���Ҫʵ�֣���Ĭ�Ϸ�������Ҫ���ӿ��ṩ��Ĭ�Ϸ����ᱻ�ӿڵ�ʵ����̳л��߸�д
 * 
 * Defaulable�ӿ�ʹ�ùؼ���default������һ��Ĭ�Ϸ���notRequired()��
 * DefaultableImpl��ʵ��������ӿڣ�ͬʱĬ�ϼ̳�������ӿ��е�Ĭ�Ϸ�����
 * OverridableImpl��Ҳʵ��������ӿڣ�����д�˸ýӿڵ�Ĭ�Ϸ��������ṩ��һ����ͬ��ʵ�֡�
 * 
 * @author Administrator
 *
 */
public interface Defaulable {
	default String notRequired() {
		return "Default implementation";
	}
}

package com.study.typeinterface;

/**
 * Java 8�������������ƶϷ����кܴ���������ںܶೡ���±����������Ƶ���ĳ���������������ͣ��Ӷ�ʹ�ô����Ϊ��ࡣ
 * @author Administrator
 *
 * @param <T>
 */
public class Value<T> {
	public static <T> T defaultValue() {
		return null;
	}

	public T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}

package com.study.typeinterface;

/**
 * Java 8编译器在类型推断方面有很大的提升，在很多场景下编译器可以推导出某个参数的数据类型，从而使得代码更为简洁。
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

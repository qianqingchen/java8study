package com.study.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Java 8�ؿ���ע���Ӧ�ó��������ڣ�ע�⼸������ʹ�����κ�Ԫ���ϣ��ֲ��������ӿ����͡�����ͽӿ�ʵ���࣬�����������ں������쳣�����ϡ�
 * 
 * @author Administrator
 *
 *         ElementType.TYPE_USE��ElementType.TYPE_PARAMETER��Java
 *         8����������ע�⣬��������ע���ʹ�ó�����Java ����Ҳ���˶�Ӧ�ĸı䣬��ʶ����Щ������ע�⡣
 *
 */
public class Annotations {
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
	public @interface NonEmpty {
	}

	public static class Holder<@NonEmpty T> extends @NonEmpty Object {
		public void method() throws @NonEmpty Exception {
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		final Holder<String> holder = new @NonEmpty Holder<String>();
		@NonEmpty
		Collection<@NonEmpty String> strings = new ArrayList<>();
	}
}

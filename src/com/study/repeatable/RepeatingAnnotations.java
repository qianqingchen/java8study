package com.study.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �Դ�Java5������ע��������������Կ�ʼ��÷ǳ����У����ڸ�����ܺ���Ŀ�б��㷺ʹ�á�������ע����һ���ܴ�������ǣ���ͬһ���ط����ܶ��ʹ��ͬһ��ע�⡣
 * Java8������������ƣ��������ظ�ע��ĸ��������ͬһ���ط����ʹ��ͬһ��ע�⡣
 * 
 * ��Java 8��ʹ��@Repeatableע�ⶨ���ظ�ע�⣬ʵ���ϣ��Ⲣ�������Բ���ĸĽ������Ǳ���������һ��trick���ײ�ļ�����Ȼ��ͬ��
 * 
 * @author Administrator
 *
 */
public class RepeatingAnnotations {
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	};

	@Filter("filter1")
	@Filter("filter2")
	public interface Filterable {
	}

	/**
	 * �������������������Filter��ʹ��@Repeatable(Filters.class)ע�����Σ���Filters�Ǵ��Filterע��������������������Կ�����������Щϸ�ڡ�
	 * ������Filterable�ӿڿ���������Filterע��ע�ͣ����ﲢû���ᵽ�κι���Filters����Ϣ����
	 * 
	 * ���⣬����API�ṩ��һ���µķ�����getAnnotationsByType()�����Է���ĳ�����͵��ظ�ע�⣬����Filterable.class.getAnnoation(Filters.class)����������Filterʵ��
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
			System.out.println(filter.value());
		}
	}
}

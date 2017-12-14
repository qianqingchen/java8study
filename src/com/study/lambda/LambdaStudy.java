package com.study.lambda;

import java.util.Arrays;

public class LambdaStudy {

	public static void main(String[] args) {
		/**
		 * Lambda
		 */
		Arrays.asList("a", "b", "c").forEach(a -> System.out.println(a));
		
		/**
		 * ��������������еĲ���e���������ɱ���������ó��ģ���Ҳ������ʽָ���ò���������
		 */
		Arrays.asList("a", "b", "c").forEach((String a) -> System.out.println(a));
		
		/**
		 *  ���Lambda���ʽ��Ҫ�����ӵ����飬�����ʹ�û����Ž���������������������Java�еĺ�����
		 */
		Arrays.asList("a", "b", "c").forEach((String a) -> {
			System.out.println(a);
		});
		
		/**
		 * Lambda���ʽ�����������Ա�;ֲ��������Ὣ��Щ������ʽ��ת����final�ģ���������������������Ч����ȫ��ͬ
		 */
		// �����1
		String separator = ",";
		Arrays.asList("a", "b", "c").forEach((String a) -> System.out.println(a + separator));
		// �����2
		final String separator1 = ",";
		Arrays.asList("a", "b", "c").forEach((String a) -> System.out.println(a + separator1));
		
		/**
		 * Lambda���ʽ�з���ֵ������ֵ������Ҳ�ɱ���������ó������Lambda���ʽ�е�����ֻ��һ�У�����Բ���ʹ��return��䣬������������Ƭ��Ч����ͬ��
		 */
		//�����1
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		//�����2
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		
		
	}

}

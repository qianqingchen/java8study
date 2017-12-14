package com.study.optional;

import java.util.Optional;

/**
 * JavaӦ���������bug���ǿ�ֵ�쳣����Java 8֮ǰ��Google
 * Guava������Optionals�������NullPointerException���Ӷ�����Դ�뱻����null�����Ⱦ���Ա㿪����д����������Ĵ��롣Java
 * 8Ҳ��Optional�����˹ٷ��⡣
 * 
 * Optional������һ�����ף����T���͵�ֵ����null�����ṩ��һЩ���õĽӿ���������ʽ��null��飬���Բο�Java 8�ٷ��ĵ��˽����ϸ�ڡ�
 * 
 * @author Administrator
 *
 */
public class Test {
	
	public static void main(String[] args) {
		System.out.println("------------------------->demo1");
		demo1();
		System.out.println("------------------------->demo2");
		demo2();
	}
	
	public static void demo1() {
		Optional< String > fullName = Optional.ofNullable( null );
		System.out.println( "Full Name is set? " + fullName.isPresent() );        
		System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
		System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
	}
	
	public static void demo2() {
		Optional< String > firstName = Optional.of( "Tom" );
		System.out.println( "First Name is set? " + firstName.isPresent() );        
		System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) ); 
		System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
		System.out.println();
	}
}

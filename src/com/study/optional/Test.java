package com.study.optional;

import java.util.Optional;

/**
 * Java应用中最常见的bug就是空值异常。在Java 8之前，Google
 * Guava引入了Optionals类来解决NullPointerException，从而避免源码被各种null检查污染，以便开发者写出更加整洁的代码。Java
 * 8也将Optional加入了官方库。
 * 
 * Optional仅仅是一个容易：存放T类型的值或者null。它提供了一些有用的接口来避免显式的null检查，可以参考Java 8官方文档了解更多细节。
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

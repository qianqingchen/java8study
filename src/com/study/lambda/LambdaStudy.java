package com.study.lambda;

import java.util.Arrays;

public class LambdaStudy {

	public static void main(String[] args) {
		/**
		 * Lambda
		 */
		Arrays.asList("a", "b", "c").forEach(a -> System.out.println(a));
		
		/**
		 * 在上面这个代码中的参数e的类型是由编译器推理得出的，你也可以显式指定该参数的类型
		 */
		Arrays.asList("a", "b", "c").forEach((String a) -> System.out.println(a));
		
		/**
		 *  如果Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于Java中的函数体
		 */
		Arrays.asList("a", "b", "c").forEach((String a) -> {
			System.out.println(a);
		});
		
		/**
		 * Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的），例如下列两个代码块的效果完全相同
		 */
		// 代码块1
		String separator = ",";
		Arrays.asList("a", "b", "c").forEach((String a) -> System.out.println(a + separator));
		// 代码块2
		final String separator1 = ",";
		Arrays.asList("a", "b", "c").forEach((String a) -> System.out.println(a + separator1));
		
		/**
		 * Lambda表达式有返回值，返回值的类型也由编译器推理得出。如果Lambda表达式中的语句块只有一行，则可以不用使用return语句，下列两个代码片段效果相同：
		 */
		//代码块1
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		//代码块2
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		
		
	}

}

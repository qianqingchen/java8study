package com.study.functionalinterface;

/**
 * Lambda的设计者们为了让现有的功能与Lambda表达式良好兼容，考虑了很多方法，于是产生了函数接口这个概念。
 * 函数接口指的是只有一个函数的接口，这样的接口可以隐式转换为Lambda表达式。java.lang.Runnable和java.util.concurrent.Callable是函数式接口的最佳例子。
 * 在实践中，函数式接口非常脆弱：只要某个开发者在该接口中添加一个函数，则该接口就不再是函数式接口进而导致编译失败。
 * 为了克服这种代码层面的脆弱性，并显式说明某个接口是函数式接口，Java8 提供了一个特殊的注解@FunctionalInterface（Java
 * 库中的所有相关接口都已经带有这个注解了），举个简单的函数式接口的定义：
 * 
 * @author Administrator
 *
 */
@FunctionalInterface
public interface FunctionalDefaultMethods extends Functional {
	void method();

	default void defaultMethod() {
	}
}

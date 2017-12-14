package com.study.packinterface;

/**
 * Java 8使用两个新概念扩展了接口的含义：默认方法和静态方法。默认方法使得接口有点类似traits，不过要实现的目标不一样。默认方法使得开发者可以在
 * 不破坏二进制兼容性的前提下，往现存接口中添加新的方法，即不强制那些实现了该接口的类也同时实现这个新加的方法。
 * 
 * 默认方法和抽象方法之间的区别在于抽象方法需要实现，而默认方法不需要。接口提供的默认方法会被接口的实现类继承或者覆写
 * 
 * Defaulable接口使用关键字default定义了一个默认方法notRequired()。
 * DefaultableImpl类实现了这个接口，同时默认继承了这个接口中的默认方法；
 * OverridableImpl类也实现了这个接口，但覆写了该接口的默认方法，并提供了一个不同的实现。
 * 
 * @author Administrator
 *
 */
public interface Defaulable {
	default String notRequired() {
		return "Default implementation";
	}
}

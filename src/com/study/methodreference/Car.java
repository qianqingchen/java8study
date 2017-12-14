package com.study.methodreference;

import java.util.function.Supplier;

/**
 * 方法引用使得开发者可以直接引用现存的方法、Java类的构造方法或者实例对象。方法引用和Lambda表达式配合使用，使得java类的构造方法看起来紧凑而简洁，没有很多复杂的模板代码。
 * 
 * 西门的例子中，Car类是不同方法引用的例子，可以帮助读者区分四种类型的方法引用。
 * 
 * @author Administrator
 *
 */
public class Car {
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
}

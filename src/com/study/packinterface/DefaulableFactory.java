package com.study.packinterface;

import java.util.function.Supplier;

/**
 * 在接口中定义静态方法
 * @author Administrator
 *
 */
public interface DefaulableFactory {
	// Interfaces now allow static methods
    static Defaulable create( Supplier<Defaulable> supplier ) {
        return supplier.get();
    }
}

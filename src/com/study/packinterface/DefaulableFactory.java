package com.study.packinterface;

import java.util.function.Supplier;

/**
 * �ڽӿ��ж��徲̬����
 * @author Administrator
 *
 */
public interface DefaulableFactory {
	// Interfaces now allow static methods
    static Defaulable create( Supplier<Defaulable> supplier ) {
        return supplier.get();
    }
}

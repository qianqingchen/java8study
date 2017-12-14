package com.study.packinterface;

import java.util.function.Supplier;

public interface OverridableImplFactory {
	// Interfaces now allow static methods
    static OverridableImpl create( Supplier<OverridableImpl> supplier ) {
        return supplier.get();
    }
}

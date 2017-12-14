package com.study.packinterface;

public class Test {
	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
		System.out.println(defaulable.notRequired());

		defaulable = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(defaulable.notRequired());
		
		OverridableImpl overridableImpl = OverridableImplFactory.create(OverridableImpl::new);
		overridableImpl.say();
	}
}

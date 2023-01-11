package de.jwausle.osgi.dynamicPackage;

import java.util.concurrent.Callable;

import de.jwausle.osgi.dynamicPackage.internal.InnerDynamicClass;

public class DynamicClass implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		return new InnerDynamicClass().random();
	}

	@Override
	public String toString() {
		return "DynamicClass.String";
	}

}

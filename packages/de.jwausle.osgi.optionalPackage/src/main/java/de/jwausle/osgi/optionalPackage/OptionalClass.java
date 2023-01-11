package de.jwausle.osgi.optionalPackage;

import java.util.concurrent.Callable;

import de.jwausle.osgi.optionalPackage.internal.InnerOptionalClass;

public class OptionalClass implements Callable<Integer> {
	
	@Override
	public Integer call() throws Exception {
		return new InnerOptionalClass().random();
	}

	@Override
	public String toString() {
		return "OptionalClass.toString";
	}
}

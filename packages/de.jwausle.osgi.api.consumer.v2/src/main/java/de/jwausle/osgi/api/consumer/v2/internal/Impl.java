package de.jwausle.osgi.api.consumer.v2.internal;

import de.jwausle.osgi.api.provider.Api;

public class Impl implements Api{

	@Override
	public void v2Call() {
		System.out.println("V2 called");
	}

}

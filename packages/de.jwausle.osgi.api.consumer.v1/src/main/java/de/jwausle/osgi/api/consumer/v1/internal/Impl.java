package de.jwausle.osgi.api.consumer.v1.internal;

import de.jwausle.osgi.api.provider.Api;

public class Impl implements Api{
	public void v1Call() {
		System.out.println("V1 called");
	}
}

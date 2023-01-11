package de.jwausle.osgi.api.consumer.v2.internal;

import de.jwausle.osgi.api.provider.Api;

public class Impl implements Api{

	public void v2Call() {
		System.out.println("Itnernal V2 called");
	}

	public void v1Call() {
		System.out.println("Internal V2 called");
	}
}

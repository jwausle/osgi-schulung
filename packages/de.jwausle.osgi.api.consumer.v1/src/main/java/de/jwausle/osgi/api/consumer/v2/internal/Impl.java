package de.jwausle.osgi.api.consumer.v2.internal;

import de.jwausle.osgi.api.provider.Api;

public class Impl implements Api{
	
	public void v2Call() {
		System.out.println("V1 called");
	}

	@Override
	public void v1Call() {
		// TODO Auto-generated method stub
	}
}

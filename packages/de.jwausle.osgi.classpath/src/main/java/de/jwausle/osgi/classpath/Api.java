package de.jwausle.osgi.classpath;

import java.net.URL;

import com.google.common.cache.Cache;

public class Api implements Runnable {

	@Override
	public void run() {
		URL resource = Cache.class.getResource('/' + Cache.class.getName().replace('.', '/') + ".class");
		System.out.println(resource);		
	}
}

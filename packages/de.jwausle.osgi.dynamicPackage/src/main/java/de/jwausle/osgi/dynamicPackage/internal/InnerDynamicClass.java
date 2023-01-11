package de.jwausle.osgi.dynamicPackage.internal;

import java.util.concurrent.ThreadLocalRandom;

public class InnerDynamicClass {
	public Integer random() {
		return ThreadLocalRandom.current().nextInt(100);
	}
}

package de.jwausle.osgi.optionalPackage.internal;

import java.util.concurrent.ThreadLocalRandom;

public class InnerOptionalClass {

	public Integer random() {
		return ThreadLocalRandom.current().nextInt(100);
	}
}

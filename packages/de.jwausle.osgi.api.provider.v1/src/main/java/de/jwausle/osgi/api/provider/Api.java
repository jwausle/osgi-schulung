package de.jwausle.osgi.api.provider;

public interface Api extends Runnable {
	default void run() {
		v1Call();
	}

	void v1Call();
}
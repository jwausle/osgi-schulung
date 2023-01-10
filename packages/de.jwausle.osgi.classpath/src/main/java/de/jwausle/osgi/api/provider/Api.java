package de.jwausle.osgi.api.provider;

public interface Api extends Runnable {

	void v2Call();

	default void run() {
		v2Call();
	}
}

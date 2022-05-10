package de.jwausle.osgi.api.provider;

public interface Api {

	void v2Call();

	default void call() {
		v2Call();
	}
}

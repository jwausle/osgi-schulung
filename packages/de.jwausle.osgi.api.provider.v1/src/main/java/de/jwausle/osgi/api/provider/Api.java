package de.jwausle.osgi.api.provider;

public interface Api {
	default void call() {
		v1Call();
	}

	void v1Call();
}
package de.jwausle.osgi.classpath.internal;

import java.util.Objects;

import org.osgi.framework.BundleContext;

@SuppressWarnings("deprecation")
public class RunCommand {

	private final BundleContext context;

	public RunCommand(BundleContext context) {
		this.context = Objects.requireNonNull(context);
	}

	/**
	 * <pre>
	 * 	new Api() {}.run();
	 * </pre>
	 */
	public void run() {
		try {
			Class<?> optionalClass = Class.forName("de.jwausle.osgi.classpath.Api");
			Runnable runnable = (Runnable) optionalClass.newInstance();
			runnable.run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

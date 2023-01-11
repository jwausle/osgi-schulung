package de.jwausle.osgi.classpath.internal;

import java.util.Hashtable;
import java.util.Optional;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private Optional<ServiceRegistration<RunCommand>> registerService = Optional.empty();

	@Override
	public void start(BundleContext context) throws Exception {
		Hashtable<String, Object> dict = new Hashtable<>();
		dict.put("osgi.command.scope", "jw");
		dict.put("osgi.command.function", new String[] { "run" });
		registerService = Optional.of(context.registerService(RunCommand.class, new RunCommand(context), dict));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registerService
		.map(ServiceRegistration<RunCommand>::getReference)
		.ifPresent(context::ungetService);
	}

}

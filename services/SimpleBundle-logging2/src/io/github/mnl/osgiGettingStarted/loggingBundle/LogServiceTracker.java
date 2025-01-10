package io.github.mnl.osgiGettingStarted.loggingBundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

final class LogServiceTracker extends ServiceTracker<LogService, LogService> {
	private HelloWorld helloWorld;

	LogServiceTracker(BundleContext context) {
		super(context, LogService.class, null);
	}

	/**
	 * This method is invoked when a service (of the kind tracked) is added. In our
	 * use case, this means that the log service is available now and that our
	 * component can be started.
	 */
	@Override
	public LogService addingService(ServiceReference<LogService> reference) {
		LogService result = super.addingService(reference);

		// The required service has become available, so we should
		// start our service if it hasn't been started yet.
		if (this.helloWorld != null) {
			stopAndUnregisterHelloWorld();
		}

		System.out.println("Hello World started.");
		this.helloWorld = new HelloWorld(context);
		// register service
		context.registerService(HelloWorld.class, this.helloWorld, null);
		this.helloWorld.start();

		return result;
	}

	/**
	 * This method is invoked when a service is removed. Since we model a strong
	 * relationship between our component and the log service, our component must be
	 * stopped when there's no log service left. Note that the service tracker
	 * remains open (active). When a log service becomes available again, our
	 * component will be restarted.
	 */
	@Override
	public void removedService(ServiceReference<LogService> reference, LogService service) {
		super.removedService(reference, service);
		// If no logging service is left, we have to stop our component.
		if (this.helloWorld != null) {
			stopAndUnregisterHelloWorld();
		}
	}

	private void stopAndUnregisterHelloWorld() {
		this.helloWorld.interrupt();
		try {
			this.helloWorld.join();
		} catch (InterruptedException e) {
		}
		this.helloWorld = null;
		context.ungetService(context.getServiceReference(HelloWorld.class));
		System.out.println("Hello World stopped.");
	}
}
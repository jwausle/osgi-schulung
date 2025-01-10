package io.github.mnl.osgiGettingStarted.loggingBundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

public class LogServiceHelper {
	private final BundleContext context;
	private ServiceReference<LogService> serviceReference;
	private final LogService singleton;


	public LogServiceHelper(BundleContext context) {
		this.context = context;
		this.serviceReference = context.getServiceReference(LogService.class);
		this.singleton = this.context.getService(this.serviceReference);
	}

	public LogService logServiceSingleton() {
		return singleton;
	}

	private LogService tryGetCurrentAndResetServiceReverenceOrNull() {
		LogService current = this.context.getService(this.serviceReference);
		// Try to reset service reference only when current reference is out dated
		if (current == null) {
			ServiceReference<LogService> serviceReference = context.getServiceReference(LogService.class);
			// Service reference is null when logging bundle(1) is stopped
			if (serviceReference != null) {
				this.serviceReference = serviceReference;
			}
		}
		return current;
	}

	public String toString() {
		LogService current = tryGetCurrentAndResetServiceReverenceOrNull();
		return "[(wired==current)=" + (this.singleton.equals(current)) + ", wired=" + this.singleton + ", current="
				+ current + "]";
	}
}

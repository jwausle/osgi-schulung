package io.github.mnl.osgiGettingStarted.loggingBundle;

import java.util.concurrent.CompletableFuture;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
	static public LogService logService = null;
	
	private ServiceRegistration<HelloWorld> registerService;
    private HelloWorld helloWorld;

    /** Our component isn't started immediately like before. Rather, a service tracker
     * is created and opened. Our component will only be started when the service
     * tracker detects the availability of all required services. */
    @Override
    public void start(BundleContext context) throws Exception {
    	System.out.println("test");
    	this.helloWorld = new HelloWorld();
    	registerService = context.registerService(HelloWorld.class, this.helloWorld , null);
    	
    	ServiceReference<LogService> serviceReference = context.getServiceReference(LogService.class);
    	logService = context.getService(serviceReference);
    	CompletableFuture.runAsync(() -> { this.helloWorld.run();});
    }

    /** As before, this method stops our component, but in a different way. It stops 
     * (closes) the service tracker (because we don't want our component to be 
     * reactivated only because a log service (re-)appears). As this causes the
     * ServiceTracker to call removedService for the tracked service(s), this will
     * also stop our service. */
    @Override
    public void stop(BundleContext context) throws Exception {
        this.helloWorld = null;
        context.ungetService(registerService.getReference());
    }
}

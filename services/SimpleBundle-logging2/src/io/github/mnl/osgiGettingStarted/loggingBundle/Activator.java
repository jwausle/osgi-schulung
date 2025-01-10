package io.github.mnl.osgiGettingStarted.loggingBundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    private ServiceTracker<LogService, LogService> logServiceTracker;

    /** Our component isn't started immediately like before. Rather, a service tracker
     * is created and opened. Our component will only be started when the service
     * tracker detects the availability of all required services. */
    @Override
    public void start(BundleContext context) throws Exception {
    	System.out.println("Starting ...");
        if (logServiceTracker == null) {
            logServiceTracker = new LogServiceTracker(context);
        }
        // Now activate (open) the service tracker.
        logServiceTracker.open();
    }

    /** As before, this method stops our component, but in a different way. It stops 
     * (closes) the service tracker (because we don't want our component to be 
     * reactivated only because a log service (re-)appears). As this causes the
     * ServiceTracker to call removedService for the tracked service(s), this will
     * also stop our service. */
    @Override
    public void stop(BundleContext context) throws Exception {
    	System.out.println("Stopping ...");
        logServiceTracker.close();
    }
}

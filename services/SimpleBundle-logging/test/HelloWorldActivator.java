import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld;

public class HelloWorldActivator implements BundleActivator {
    private ServiceTracker<LogService, LogService> logServiceTracker;
    private HelloWorld helloWorld;

    @Override
    public void start(BundleContext context) throws Exception {
        if (logServiceTracker == null) {
            logServiceTracker = new ServiceTracker<LogService, LogService>(context, LogService.class, null) {
                @Override
                public LogService addingService(ServiceReference<LogService> reference) {
                    LogService result = super.addingService(reference);
                    helloWorld = new HelloWorld(context);
                    System.out.println("Hello World started.");
                    return result;
                }

                @Override
                public void removedService(ServiceReference<LogService> reference, LogService service) {
                    super.removedService(reference, service);
                    helloWorld = null;
                    System.out.println("Hello World stopped.");
                }
            };
        }
        logServiceTracker.open();
    }

    /**
     * As before, this method stops our component, but in a different way. It stops
     * (closes) the service tracker (because we don't want our component to be
     * reactivated only because a log service (re-)appears). As this causes the
     * ServiceTracker to call removedService for the tracked service(s), this will
     * also stop our service.
     */
    // @Override
    public void stop(BundleContext context) throws Exception {
        logServiceTracker.close();
    }
}

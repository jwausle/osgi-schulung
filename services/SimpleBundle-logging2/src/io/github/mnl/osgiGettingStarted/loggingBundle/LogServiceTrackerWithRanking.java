package io.github.mnl.osgiGettingStarted.loggingBundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

final class LogServiceTrackerWithRanking extends ServiceTracker<LogService, LogService> {
	private HelloWorld helloWorld;

	LogServiceTrackerWithRanking(BundleContext context) {
		super(context, LogService.class, null);
	}

	/** This method is invoked when a service (of the kind tracked)
	 * is added. In our use case, this means that the log service is 
	 * available now and that our component can be started. */
	@Override
	public LogService addingService(ServiceReference<LogService> reference) {
	    LogService result = super.addingService(reference);
	    // If there are several services available, getService() returns the
	    // preferred one. But we cannot use getService() here because the new
	    // service hasn't been added to the tracked services yet (we're in 
	    // the process of adding). We have to decide on our own.
	    if (isPreferred(reference)) {
	    	if(this.helloWorld != null) {
	    		this.helloWorld.reset(result);
	    	}
	    }
	    // The required service has become available, so we should 
	    // start our service if it hasn't been started yet.
	    if (this.helloWorld == null) {
	        System.out.println("Hello World started.");
	        this.helloWorld = new HelloWorld(context);
	        // register service
	        context.registerService(HelloWorld.class, this.helloWorld , null);
	        this.helloWorld.start();
	    }
	    return result;
	}

	// When having several services, which one should be used? The ServiceTracker
	// prefers services with higher ranking and, if there is a tie, the service 
	// with the lowest service id.
	private boolean isPreferred(ServiceReference<LogService> candidate) {
	    ServiceReference<LogService> current = getServiceReference();
	    if (current == null) {
	        // If this is the first reference use it!
	        return true;
	    }
	    Object property = current.getProperty(Constants.SERVICE_RANKING);
	    int currentRanking = (property instanceof Integer) 
	            ? ((Integer) property).intValue() : 0;
	    property = candidate.getProperty(Constants.SERVICE_RANKING);
	    int candidateRanking = (property instanceof Integer) 
	            ? ((Integer) property).intValue() : 0;
	    if (candidateRanking > currentRanking) {
	        return true;
	    }
	    if (candidateRanking == currentRanking) {
	        long currentId = ((Long) 
	                (current.getProperty(Constants.SERVICE_ID))).longValue();
	        long candidateId = ((Long) 
	                (candidate.getProperty(Constants.SERVICE_ID))).longValue();
	        if (candidateId < currentId) {
	            return true;
	        }
	    }
	    return false;
	}

	/** This method is invoked when a service is removed. Since we model
	 * a strong relationship between our component and the log service,
	 * our component must be stopped when there's no log service left.
	 * Note that the service tracker remains open (active). When a log
	 * service becomes available again, our component will be restarted. */
	@Override
	public void removedService(ServiceReference<LogService> reference,
	                           LogService service) {
	    super.removedService(reference, service);	    
	    // If no logging service is left, we have to stop our component.
	    if (this.helloWorld != null) {
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
}
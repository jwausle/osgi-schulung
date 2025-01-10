package io.github.mnl.osgiGettingStarted.loggingBundle;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;

public class Activator implements BundleActivator {
	private ServiceRegistration<HelloWorld> registerService;
    private HelloWorld helloWorld;

    @Override
    public void start(BundleContext context) throws Exception {
    	System.out.println(propertiesToString(context.getServiceReference(LogService.class)));
    	
    	this.helloWorld = new HelloWorld(context);
    	CompletableFuture.runAsync(this.helloWorld);
		registerService = context.registerService(HelloWorld.class, this.helloWorld , null);
    	
    	System.out.println(propertiesToString(context.getServiceReference(HelloWorld.class)));
    }


    @Override
    public void stop(BundleContext context) throws Exception {
        this.helloWorld = null;
        context.ungetService(registerService.getReference());
    }
    
    
    private static String propertiesToString(ServiceReference<?> serviceReference) {
    	return Arrays.stream(serviceReference.getPropertyKeys())
    			.map(key -> key + ": " + propertyToString(serviceReference, key))
    			.collect(Collectors.joining(", "));
    }


	private static String propertyToString(ServiceReference<?> serviceReference, String key) {
		Object value = serviceReference.getProperty(key);
		if(value == null) {
			return "null";
		}
		if(value instanceof String[]) {
			return Arrays.toString((String[]) value);
		}
		return value.toString();
	}
}

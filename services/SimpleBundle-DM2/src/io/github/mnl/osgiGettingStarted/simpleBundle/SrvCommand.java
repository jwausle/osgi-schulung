package io.github.mnl.osgiGettingStarted.simpleBundle;

import java.util.stream.Stream;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(property = { "osgi.command.scope:String=jw",
		"osgi.command.function:String=srv" }, service = SrvCommand.class)
public class SrvCommand {

    private BundleContext context;        
	
	@Activate
	void activate(ComponentContext context) { this.context = context.getBundleContext(); }

//    @Descriptor("List all services")
    public ServiceReference<?>[] srv() throws InvalidSyntaxException {
        return context.getAllServiceReferences(null, null);
    }

//    @Descriptor("List all services that match the name")
    public ServiceReference<?>[] srv(
            String... names)
            throws InvalidSyntaxException {
        ServiceReference<?>[] allServiceReferences = 
            context.getAllServiceReferences(null,null);
        if ( allServiceReferences==null)
            return new ServiceReference[0];
        return Stream.of(allServiceReferences)
                .filter(r -> {
                    String[] objectClass = (String[]) r.getProperty(Constants.OBJECTCLASS);
                    for (String oc : objectClass) {
                        for (String name : names)
                            if (oc.contains(name))
                                return true;
                    }
                    return names.length == 0;
                }).sorted().toArray(ServiceReference[]::new);
    }
}

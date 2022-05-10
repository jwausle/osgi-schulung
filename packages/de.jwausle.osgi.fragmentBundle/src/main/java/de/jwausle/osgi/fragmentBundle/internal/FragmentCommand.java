package de.jwausle.osgi.fragmentBundle.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(property = { "osgi.command.scope:String=jw", "osgi.command.function:String=fgm2"}, service = FragmentCommand.class)
public class FragmentCommand {
	
	private String hostClassName = "de.jwausle.osgi.fragmentHost.internal.FragmentHostCommand";
	
	private BundleContext bundleContext;

	@Activate
	void activate(ComponentContext context) {
		this.bundleContext = context.getBundleContext();
	}

	public void fgm2() throws Exception {
		System.out.println("Bundle-Context: " + bundleContext);
		
		Class<?> hostClass = Class.forName(hostClassName);
		Object hostClassInstance = hostClass.getDeclaredConstructor().newInstance();
		System.out.println(hostClass + " instance: " + hostClassInstance);
	}
}

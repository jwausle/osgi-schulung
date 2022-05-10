package de.jwausle.osgi.example01.internal;

import org.osgi.service.component.annotations.Component;

@Component(property = { "osgi.command.scope:String=jw", "osgi.command.function:String=dyn"}, service = DynamicCommand.class)
public class DynamicCommand {

	public void dyn() throws Exception {
		Class<?> dynamicClass = Class.forName("de.jwausle.osgi.dynamicPackage.DynamicClass");
		Object newInstance = dynamicClass.getDeclaredConstructor().newInstance();
		System.out.println("Load and instantiate - " + newInstance);
	}
}

package de.jwausle.osgi.example01.internal;

import org.osgi.service.component.annotations.Component;

@Component(property = { "osgi.command.scope:String=jw", "osgi.command.function:String=opt" }, service = OptionalCommand.class)
public class OptionalCommand {

	public void opt() throws Exception {
		Class<?> optionalClass = Class.forName("de.jwausle.osgi.optionalPackage.OptionalClass");
		Object newInstance = optionalClass.getDeclaredConstructor().newInstance();
		System.out.println("Load and instantiate - " + newInstance);
	}
}

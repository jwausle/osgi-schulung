package de.jwausle.osgi.fragmentBundle.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.stream.Collectors;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(property = { "osgi.command.scope:String=jw", "osgi.command.function:String=fgm2"}, service = FragmentCommand.class)
public class FragmentCommand {
	
	private BundleContext bundleContext;

	@Activate
	void activate(ComponentContext context) {
		this.bundleContext = context.getBundleContext();
	}

	public void fgm2() throws Exception {
		System.out.println("--------------------------------------------------");
		System.out.println("Fragment context: " + bundleContext);
		System.out.println("--------------------------------------------------");
		printFolder(bundleContext.getBundle().findEntries("/folder", null, false));
		System.out.println("--------------------------------------------------");
		printFolder(FragmentCommand.class.getClassLoader().getResources("/folder/file.txt"));
	}

	public void printFolder(Enumeration<URL> findEntries) throws Exception { 
		while(findEntries.hasMoreElements()) {
			URL nextElement = findEntries.nextElement();
			System.out.println(nextElement);
			String content = new BufferedReader(
				      new InputStreamReader(nextElement.openStream(), StandardCharsets.UTF_8))
				        .lines()
				        .collect(Collectors.joining("\n"));
			System.out.println(content);
		}
		
	}
}

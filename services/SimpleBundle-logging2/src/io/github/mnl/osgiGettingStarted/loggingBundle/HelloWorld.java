/**
 * 
 */
package io.github.mnl.osgiGettingStarted.loggingBundle;

import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

/**
 * @author mnl
 *
 */
public class HelloWorld extends Thread{

	private LogService wired;
	private final LogServiceHelper helper;

	public HelloWorld(BundleContext context) {
		this.helper = new LogServiceHelper(context);
		this.wired = this.helper.logServiceSingleton();
	}

	@Override
	public void run() {
		System.out.println("Hello World!");
		while (!isInterrupted()) {
			try {
				if (this.wired != null) {
					String threadName = Thread.currentThread().getName();
					String message = "[" + threadName + "] " + "Hello Word sleeping: " + this.helper;
					System.out.println("WARNING: " + message);
					this.wired.log(LogService.LOG_WARNING, message);
				}
				sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Break Hello World!");
				break;
			}
		}
	}

	public void reset(LogService logService) {
		this.wired = logService;
	}
}

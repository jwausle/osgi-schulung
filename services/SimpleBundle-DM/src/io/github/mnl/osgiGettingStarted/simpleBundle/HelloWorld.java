/**
 * 
 */
package io.github.mnl.osgiGettingStarted.simpleBundle;

import org.osgi.service.log.LogService;

/**
 * @author mnl
 *
 */
public class HelloWorld extends Thread {

	private volatile LogService logService;
	
	public void init() {
		System.out.println(">>> Lifecycle hook from DependencyManager on construction");
	}
	
	@Override
	public void start() {
		System.out.println(">>> Lifecycle hook from DependencyManager on start");
		super.start();
	}
	
    @Override
    public void run() {
        System.out.println("Hello World!");
        while (!isInterrupted()) {
            try {
                logService.log(LogService.LOG_INFO, "Hello Word sleeping");
                sleep (5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

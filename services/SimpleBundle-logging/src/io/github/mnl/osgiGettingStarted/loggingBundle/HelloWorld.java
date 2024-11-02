/**
 * 
 */
package io.github.mnl.osgiGettingStarted.loggingBundle;

import org.osgi.service.log.LogService;

/**
 * @author mnl
 *
 */
public class HelloWorld extends Thread {
  
    public HelloWorld() {
      this(null);
    }

    public HelloWorld(Object object) {
    }

    @Override
    public void run() {
        System.out.println("Hello World!");
        while (!isInterrupted()) {
            try {
                Activator.logService.log(LogService.LOG_WARNING, "Hello Word sleeping");
                sleep (5000);
            } catch (InterruptedException e) {
            	System.out.println("Break Hello World!");
                break;
            }
        }
    }
    
}

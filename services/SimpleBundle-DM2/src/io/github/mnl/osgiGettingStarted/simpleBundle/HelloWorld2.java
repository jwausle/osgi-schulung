/**
 * 
 */
package io.github.mnl.osgiGettingStarted.simpleBundle;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

/**
 * @author mnl
 *
 */
@Component
public class HelloWorld2 implements Runnable {

	private volatile LogService logService;

	private Thread runner;
	
	@Activate
	public void start() {
		runner = new Thread(this);
		runner.start();
	}
	
	@Deactivate
	public void stop() {
		runner.interrupt();
		try {
			runner.join();
		} catch (InterruptedException e) {
			logService.log(LogService.LOG_WARNING, 
					"Could not terminate thread properly", e);
		}
	}
	
	@Reference
	public void bindLogService(LogService logService) {
	    this.logService = logService;
	}
	
	@Override
    public void run() {
        System.out.println("Hello World2!");
        while (!runner.isInterrupted()) {
            try {
                logService.log(LogService.LOG_WARNING, "Hello Word2 sleeping");
                Thread.sleep (5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}

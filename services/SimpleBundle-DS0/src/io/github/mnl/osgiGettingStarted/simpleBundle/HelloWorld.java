/**
 * 
 */
package io.github.mnl.osgiGettingStarted.simpleBundle;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.log.LogService;

public class HelloWorld implements Runnable {

    private volatile LogService logService;

    private Thread runner;
    
    
    //Reflected by DS implementation when LogService gone
    protected void setLogService(LogService logService) {
        this.logService = logService;
        System.out.println("Bound log service to HelloWorld");
    }

    //Reflected by DS implementation when LogService gone 
    protected  void unsetLogService(LogService logService) {
    	System.out.println("Unbound log service from HelloWorld");
        this.logService = null;
    }

    //Reflected by DS implementation on start
    public void start(ComponentContext ctx) {
        runner = new Thread(this);
        runner.start();
    }
    
    //Reflected by DS implementation on stop
    public void stop(ComponentContext ctx) {
        runner.interrupt();
        try {
            runner.join();
        } catch (InterruptedException e) {
            logService.log(LogService.LOG_WARNING, 
                    "Could not terminate thread properly", e);
        }
    }
    
    @Override
    public void run() {
        System.out.println("Hello World!");
        while (!runner.isInterrupted()) {
            try {            	
                logService.log(LogService.LOG_INFO, "Hello Word sleeping");
                Thread.sleep (5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

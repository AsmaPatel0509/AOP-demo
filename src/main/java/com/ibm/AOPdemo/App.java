package com.ibm.AOPdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
	private static Logger Logger = LoggerFactory.getLogger(App.class);
	public void method1() {
		Logger.trace("Trace message");
		Logger.debug("Debug message");
		Logger.info("Informational message");
		Logger.warn("Warning message");
		Logger.error("Error message");
		
		try {
			int i = 1/0;
		}catch (Exception e) {
			Logger.error(e.getMessage());
			Logger.error("Exception", e);
			Logger.error("Exception", e);
		}
	}
	public void method2() {
		Logger.info("Method 2 Started");
		Logger.info("Method 2 Ended");
	}
	
    public static void main( String[] args )
    {
        App obj = new App();
        obj.method1();
        obj.method2();
    }
}

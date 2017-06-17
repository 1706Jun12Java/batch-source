package com.revature.mavenDemo;

import org.apache.log4j.Logger;

public class LoggingClass {

	private static Logger log = Logger.getRootLogger();
	
	public void someMethod(){
		log.trace("trace message");
		log.debug("debug message");
		log.info("info message");
		log.warn("warn message");
		log.error("error message");
		log.fatal("fatal message");
	}
	
	public void giveFatal(Throwable t){
		log.fatal(t.getMessage(),t);
	}
	
}

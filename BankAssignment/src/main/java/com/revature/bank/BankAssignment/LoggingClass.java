package com.revature.bank.BankAssignment;

import org.apache.log4j.Logger;

public class LoggingClass {


		private static Logger Log = Logger.getRootLogger();
		
		public void someMethod(){
			Log.trace("trace message");
			Log.debug("debug message");
			Log.info("info message");
			Log.warn("warn message");
			Log.error("error message");
			Log.fatal("fatal message");
		}
		
		public void giveFatal(Throwable t){
			Log.fatal(t.getMessage(),t);
		}
	

}

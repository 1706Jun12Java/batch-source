package com.revature.mavenDemo;

public class App {

	public static void main(String[] args) {
		System.out.println("hello world");
		LoggingClass logger = new LoggingClass();
		logger.someMethod();
		
		try {
			exceptionThrowingGarbage();
		} catch (RuntimeException r){
			logger.giveFatal(r);
		}
	}
	
	public static void exceptionThrowingGarbage(){
		int i = 5/0;
	}

}

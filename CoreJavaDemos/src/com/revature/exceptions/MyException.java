package com.revature.exceptions;

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11359356381490345L;

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

class BadNumberException extends MyException {
	public BadNumberException(){
		super("I don't like this number");
	}
}

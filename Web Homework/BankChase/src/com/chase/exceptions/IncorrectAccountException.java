package com.chase.exceptions;

public class IncorrectAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectAccountException() {
	}

	public IncorrectAccountException (String message){
		super (message);
	}
}

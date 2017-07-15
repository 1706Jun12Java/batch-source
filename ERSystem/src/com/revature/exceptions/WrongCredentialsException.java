package com.revature.exceptions;

public class WrongCredentialsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730884880280828850L;

	public WrongCredentialsException() {
		super("Wrong username or password");
	}

}

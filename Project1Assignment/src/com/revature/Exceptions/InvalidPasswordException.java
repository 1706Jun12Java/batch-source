package com.revature.Exceptions;

public class InvalidPasswordException extends Exception{


	private static final long serialVersionUID = 1485572390387202456L;
	public InvalidPasswordException() {
		// TODO Auto-generated constructor stub
	}
	public InvalidPasswordException(String message) {
		super(message);
	}
}

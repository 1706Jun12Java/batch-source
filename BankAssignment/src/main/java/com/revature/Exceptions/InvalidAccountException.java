package com.revature.Exceptions;

public class InvalidAccountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5158757697888524163L;

	public InvalidAccountException() {
	}
	public InvalidAccountException(String message){
		super(message);
	}

}

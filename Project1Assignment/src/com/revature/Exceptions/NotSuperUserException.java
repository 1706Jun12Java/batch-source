package com.revature.Exceptions;

public class NotSuperUserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214484427233796484L;

	public NotSuperUserException() {
		// TODO Auto-generated constructor stub
	}
	
	public NotSuperUserException(String message){
		super(message);
	}

}

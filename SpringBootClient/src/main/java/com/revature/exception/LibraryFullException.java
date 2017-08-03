package com.revature.exception;

public class LibraryFullException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LibraryFullException() {
	}
	
	public LibraryFullException(String message){
		super(message);
	}	

}

package com.revature.bank.exception;

public class UniqueIDException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8633311505837492014L;

	public UniqueIDException(){
		super("User already taken");
	}
}

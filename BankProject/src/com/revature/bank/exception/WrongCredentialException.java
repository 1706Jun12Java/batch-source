package com.revature.bank.exception;

public class WrongCredentialException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5628098506007505836L;

	public WrongCredentialException(){
		super("Wrong username or password");
	}
}

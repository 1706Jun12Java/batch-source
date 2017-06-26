package com.revature.Exceptions;

public class OverDraftException extends Exception {


	private static final long serialVersionUID = 6280851892987675503L;

	public OverDraftException() {
		
	}
	
	public OverDraftException(String message) {
		super(message);
	}
}

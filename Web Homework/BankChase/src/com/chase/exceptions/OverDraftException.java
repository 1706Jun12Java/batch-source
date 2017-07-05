package com.chase.exceptions;

public class OverDraftException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverDraftException() {
	}

	public OverDraftException(String message){
		super(message);
	}
}

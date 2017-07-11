package com.revature.servlet;

public class ToConvert {

	public ToConvert(String message, String method) {
		super();
		this.message = message;
		this.method = method;
	}

	public ToConvert() {
	}

	private String message;
	private String method;

	@Override
	public String toString() {
		return message + " " + method;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}

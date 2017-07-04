package com.jdbcbank.domain;

public class OverdraftException extends Exception {
	
	public OverdraftException(){
		
	}
	
	public OverdraftException(String msg)
    {
        super(msg);
    }
}

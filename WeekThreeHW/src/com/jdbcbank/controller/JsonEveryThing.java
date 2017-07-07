package com.jdbcbank.controller;

import java.util.HashMap;

import com.jdbcbank.domain.TransactionBalance;

public class JsonEveryThing {
	public String username;
	public HashMap<Integer, TransactionBalance>  accounts;
	
	public JsonEveryThing(String username, HashMap<Integer, TransactionBalance> account_transation){
		super();
		this.username = username;
		this.accounts = account_transation;
	}
}
 
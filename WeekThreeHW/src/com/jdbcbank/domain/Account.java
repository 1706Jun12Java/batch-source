package com.jdbcbank.domain;

import java.io.IOException;
import java.sql.SQLException; 
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jdbcbank.dao.*;

public class Account {

	private LocalDateTime today;   
	
	public List<Transaction> getListTransaction() throws SQLException, IOException{
		TransactionDao td = new TransactionDaoImpl(); 
		return td.getTransaction(this);
	}
	
	public void addAccountToDB() throws SQLException, IOException{
		AccountDao ad = new AccountDaoImpl();
		ad.createAccount(this);  
	}
	
	public void removeAccountFromDB() throws SQLException, IOException{
		AccountDao ad = new AccountDaoImpl();
		ad.deleteAccount(this); 
		Transaction t = new Transaction(this.account_id, "ACCOUNT DELETED", 0, this.today);
		t.addTransactionToDB();
	}
	
	public void depositToAccount(float money) throws SQLException, IOException{
		AccountDao ad = new AccountDaoImpl();
		ad.depositAccount(this, money);
		Transaction t = new Transaction(this.account_id, "DEPOSIT", money, this.today);
		t.addTransactionToDB();
	}

	public void withrawFromAccount(float money) throws SQLException, IOException, OverdraftException{
	 
//		if ( money > this.balance){
//			throw new OverdraftException();
//		}
		
		AccountDao ad = new AccountDaoImpl();
		ad.withdrowAccount(this, money);
		Transaction t = new Transaction(this.account_id, "WITHDRAW", money, this.today);
		t.addTransactionToDB();
	}
	
	public Account(int account_id, int user_id, float balance, int account_active) {
		super(); 
		this.account_id = account_id;
		this.user_id = user_id;
		this.balance = balance; 
		this.today =  LocalDateTime.now();
		this.account_active =account_active; 
	}
	
  
	public Account(int account_id) {
		this(account_id, 0, 0, 1 ); 
	}
	
	
	private int account_id;
	private int user_id;
	private float balance;
	private int account_active;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", user_id=" + user_id + ", balance=" + balance + "]";
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getAccountActive(){
		return account_active;
	}
	
	public void setAccountActive(int account_active){
		this.account_active = account_active;
	}
}

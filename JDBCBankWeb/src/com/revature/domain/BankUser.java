package com.revature.domain;

public class BankUser {
	public BankUser(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	public BankUser(String username){
		super();
		this.username = username;
	}
	
	public BankUser(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}
	
	private int userId;
	private String username;
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "BankUser [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}

}

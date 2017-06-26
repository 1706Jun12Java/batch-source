package com.revature.domain;

public class Bank_User {
	
	public Bank_User(int user_id, String username, String password, String fname, String lname, int superUser) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.superUser = superUser;
	}


	private int user_id;
	private String username, password, fname, lname;
	private int superUser;


	public Bank_User() {
		
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
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


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public int getSuperUser() {
		return superUser;
	}


	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}


	@Override
	public String toString() {
		return "Bank_User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", fname="
				+ fname + ", lname=" + lname + ", superUser=" + superUser + "]";
	}
	
	public int userIDInt() {
		return user_id;
	}
	
	
}

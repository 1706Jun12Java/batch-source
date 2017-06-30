package com.revature.domain;

public class User {

	private int userID;
	private String username;
	private String password;
	private int userType;
	

	public User(int userID, String username, String password, int userType) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.userType = 0;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ "]";
	}
}

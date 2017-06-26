package com.revature.leibniz.bankAccountAssignment;

/**
 * 
 * @author Leibniz Berihuete
 * This is the user class, it holds the authentication info of each user.
 *
 */
public class User {
	private int userID;
	private String username;
	private String password;
	
	// Default Constructor
	public User() {}
	
	// Constructor(String, String) 
	public User(int userID, String username, String password) {
		
		this.userID = userID;
		this.username = username;
		this.password = password;
	}

	//======== GETTERS ==========//
	public int getUserID() {
		return userID;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	
	// =========== SETTERS ============ //
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

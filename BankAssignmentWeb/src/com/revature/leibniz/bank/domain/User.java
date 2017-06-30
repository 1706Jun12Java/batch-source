package com.revature.leibniz.bank.domain;

import java.io.Serializable;

/**
 * 
 * @author Leibniz Berihuete
 * A user, is a regular user, they are not SuperUser, it includes
 * user_id
 * username
 * password
 * person_id
 * 
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5337699655745998955L;
	private int userID;
	private String username;
	private String password;
	private int personID;
	
	// DEFAULT CONSTRUCTOR
	public User() {}
	
	// CONSTRUCTOR(int, String, String, int)
	public User (int userID, String username, String password, int personID) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.personID = personID;
	}

	// ========= GETTERS =========== //
	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getPersonID() {
		return personID;
	}

	
	// ============ SETTERS ==============//
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	

}

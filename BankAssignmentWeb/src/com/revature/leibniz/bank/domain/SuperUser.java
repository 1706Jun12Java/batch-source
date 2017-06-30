package com.revature.leibniz.bank.domain;

import java.io.Serializable;

/**
 * 
 * @author Leibniz Berihuete
 * SuperUser, it is more of a manager than a regular user, it includes
 * superUserID
 * username
 * password
 * personID
 */
public class SuperUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2387855100257773270L;
	private int superUserID;
	private String username;
	private String password;
	private int personID;
	
	// DEFAULT CONSTRUCTOR
	public SuperUser() {}
	
	// CONSTRUCTOR(int, String, String, int)
	public SuperUser(int superUserID, String username, String password, int personID) {
		this.superUserID = superUserID;
		this.username = username;
		this.password = password;
		this.personID = personID;
	}

	//========= GETTERS ============//
	public int getSuperUserID() {
		return superUserID;
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
	
	
	// ============= SETTERS =================//
	public void setSuperUserID(int superUserID) {
		this.superUserID = superUserID;
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

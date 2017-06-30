package com.revature.leibniz.bank.domain;

import java.io.Serializable;

/**
 * 
 * @author Leibniz Berihuete
 * Person is the basic information of a user, it includes:
 * Person_ID
 * First name
 * Last name 
 */
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6605828108684651500L;
	private int personID;
	private String firstname;
	private String lastname;
	
	// DEFAULT CONSTRUCTOR
	public Person() {}
	
	// CONSTRUCTOR (int, String, String)
	public Person(int personID, String firstname, String lastname) {
		this.personID = personID;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	
	//============ GETTERS =============//
	public int getPersonID() {
		return personID;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	// ============== SETTERS ==============//
	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
	

}

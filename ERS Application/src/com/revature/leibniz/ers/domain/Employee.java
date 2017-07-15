package com.revature.leibniz.ers.domain;

import java.io.Serializable;

/**
 * 
 * @author Leibniz Berihuete
 * This class represents an employee, an employee can be either a regular employee or manager.
 * It contains:
 *  ID
 *  FIRSTNAME
 *  LASTNAME
 *  USERNAME
 *  PASSWORD
 *  EMAIL
 *  ROLE
 */
public class Employee implements Serializable {
	// Final variables
	private static final long serialVersionUID = -4515018596544824883L;
	public static final String MANAGER_ROLE = "MANAGER";
	public static final String EMPLOYEE_ROLE = "EMPLOYEE";
	
	// Employee info:
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String role;
	
	
	// DEFAULT CONSTRUCTOR
	public Employee() {}
	
	// CONSTRUCTOR(int, String, String, String, String, String, String)
	public Employee(int id, String firstname, String lastname, String username, String password, String email, String role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	//======== FLUENT SETTERS============//
	public Employee setID(int id) {
		this.id = id;
		return this;
	}
	
	public Employee setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public Employee setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public Employee setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public Employee setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public Employee setRole(String role) {
		this.role = role;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getManagerRole() {
		return MANAGER_ROLE;
	}

	public static String getEmployeeRole() {
		return EMPLOYEE_ROLE;
	}

	// =========== GETTERS ============ //
	public int getID() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
	
	

}

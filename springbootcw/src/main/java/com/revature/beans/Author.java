package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;

public class Author implements Serializable {
	private static final long serialVersionUID = -393310509512163122L;
	
	@Column(name="AUTHOR_ID")
	private int id;
	
	@Column(name="AUTHOR_FIRSTNAME")
	private String firstName;
	
	@Column(name="AUTHOR_LASTNAME")
	private String lastName;
	
	public Author() {
		
	}

	public Author(int id, String firstName, String lastName) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	


	
	

}

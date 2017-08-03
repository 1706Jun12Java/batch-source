package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="AUTHOR")
public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4392709583037732704L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorSeq")
	@SequenceGenerator(allocationSize = 1, name = "authorSeq", sequenceName = "AUTHOR_SEQ")
	@Column(name = "A_ID")
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Column(name="LASTNAME")
	private String lastname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

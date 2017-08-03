package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "AUTHORS")
public class Author {

	public Author() {
		super();
	}

	public Author(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorSequence")
	@SequenceGenerator(allocationSize = 1, name = "authorSequence", sequenceName = "AUTHOR_SEQ")
	@Column(name = "AUTHOR_ID")
	private int id;

	@Column(name = "AUTHOR_FIRSTNAME")
	private String firstname;

	@Column(name = "AUTHOR_LASTNAME")
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}

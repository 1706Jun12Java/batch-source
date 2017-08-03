package com.revature.beans;

import java.io.Serializable;

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
@Table(name="AUTHOR")
public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Author(int authorId, String firstname, String lastname) {
		super();
		this.authorId = authorId;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorSeq")
	@SequenceGenerator(allocationSize = 1, name = "authorSeq", sequenceName = "AUTHOR_SEQ")
	@Column(name = "A_ID")
	private int authorId;
	
	@Column(name="FNAME")
	private String firstname;
	@Column(name="LNAME")
	private String lastname;

	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}

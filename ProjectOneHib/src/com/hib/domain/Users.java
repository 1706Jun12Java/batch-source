package com.hib.domain;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564506697059411612L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(allocationSize = 1, name="userSequence", sequenceName="USER_SEQ")
	@Column(name="U_ID")
	private int id;
	
	@Column(name="USERNAME", unique=true)
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAIL", unique=true)
	private String email;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="USER_ROLE")
	private UserRoles userRoles;

	public Users(String username, String password, String firstName, String lastName, String email,
			UserRoles userRoles) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoles = userRoles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userRoles=" + userRoles + "]";
	}
	
}

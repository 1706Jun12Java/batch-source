package com.hib.domain;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name="USER_ROLE")
public class UserRoles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1386883059033864440L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roleSequence")
	@SequenceGenerator(allocationSize = 1, name="roleSequence", sequenceName="USER_ROLE_SEQ")
	@Column(name="R_ID")
	private int id;
	
	@Column(name="USER_ROLE")
	private String userRole;

	public UserRoles(String userRole) {
		super();
		this.userRole = userRole;
	}
	
	public UserRoles(int id, String userRole) {
		super();
		this.id = id;
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", userRole=" + userRole + "]";
	}
	
}

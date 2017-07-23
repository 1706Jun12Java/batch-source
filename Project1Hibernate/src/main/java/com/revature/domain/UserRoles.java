package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="REIM_USER_ROLES")
public class UserRoles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401431289389949462L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urSeq")
	@SequenceGenerator(allocationSize = 1, name = "urSeq", sequenceName = "UR_SEQ")
	@Column(name="UR_ID")
	private int id;
	
	
	@Column(name = "USER_ROLE")
	protected String userRole;
	
	
	@OneToMany(mappedBy="role",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<User> members;
	public List<User> getMembers() {
		return members;
	}
	
	public UserRoles() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRoles(String userRole) {
		super();
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

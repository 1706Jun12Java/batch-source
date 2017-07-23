package com.hers.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HERS_USER_ROLE")
public class UserRoleModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3972725277764218482L;

	public UserRoleModel(int id, String role) {
		super();
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userRoleSequence")
	@SequenceGenerator(allocationSize=1, name="userRoleSequence", sequenceName="USER_ROLE_SEQ")
	@Column(name="UR_ID")
	private int id;
	
	@Column(name="UR_ROLE")
	private String role;
	
	@OneToMany(mappedBy="userRole", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<UserModel> users;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role=" + role + "]";
	}
	
	public List<UserModel> getUsers() {
		return users;
	}

}

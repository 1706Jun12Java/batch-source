package com.hers.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class UserModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5917179226220571758L;

	public UserModel(int userId, String username, String password, String firstName, String lastName, String email,
			UserRoleModel userRole) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}
	
	public UserModel(int userId, String username, String firstName, String lastName, String email, UserRoleModel userRole) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(allocationSize=1, name="userSequence", sequenceName="USER_SEQ")
	@Column(name="U_ID")
	private int userId;
	
	@Column(name="U_USERNAME", unique=true)
	private String username;
	
	@Column(name="U_PASSWORD")
	private String password;
	
	@Column(name="U_FIRSTNAME")
	private String firstName;
	
	@Column(name="U_LASTNAME")
	private String lastName;
	
	@Column(name="U_EMAIL", unique=true)
	private String email;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="UR_ID")
	private UserRoleModel userRole;
	
//	@OneToMany(mappedBy="author", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<ReimbursementModel> reimbursementsAuthor;
//	
//	@OneToMany(mappedBy="resolver", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<ReimbursementModel> reimbursementsResolver;
//	
	
	public int userId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
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
	public UserRoleModel getRole() {
		return userRole;
	}
	public void setRole(UserRoleModel userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "ErsUser [id=" + userId + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userRole=" + userRole + "]";
	}
	
}

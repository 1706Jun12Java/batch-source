package com.revature.domain;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="REIM_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3187453597160217592L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
	@SequenceGenerator(allocationSize = 1, name = "userSeq", sequenceName = "REIM_USER_SEQ")
	@Column(name = "USER_ID")
	protected int id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	@Column(name="FNAME")
	private String fName;

	@Column(name="LNAME")
	private String lName;

	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="REIM_USER_ROLES")
	private UserRoles role;
	
	@OneToMany(mappedBy="author",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reimbursements> members;
	public List<Reimbursements> getMembers() {
		return members;
	}
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String username, String password, String fName, String lName, String email, UserRoles userRole) {
		super();
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.role = userRole;
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


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UserRoles getUserRole() {
		return role;
	}


	public void setUserRole(UserRoles userRole) {
		this.role = userRole;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fName=" + fName + ", lName="
				+ lName + ", email=" + email + ", userRole=" + role + "]";
	}
	

}

package Domain;

public class ERUser {

	public ERUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public ERUser() {
		super();
	}

	public ERUser(String email, String password, String firstname, String lastname, String role) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}

	String email;
	String password;
	String firstname;
	String lastname;
	String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ERUser [email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", role=" + role + "]";
	}

}

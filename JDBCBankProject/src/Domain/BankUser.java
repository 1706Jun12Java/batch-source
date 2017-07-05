package Domain;

public class BankUser {
	public BankUser(String username, String password, int admin) {
		super();
		this.username = username;
		this.password = password;
		if (admin == 0)
			this.admin = false;
		else
			this.admin = true;
	}

	public BankUser() {
		super();
	}

	public BankUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	String username;
	String password;
	boolean admin;

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}

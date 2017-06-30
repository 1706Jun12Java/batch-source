package Domain;

public class Account {
	public Account(int iD, String username, double amount) {
		super();
		ID = iD;
		this.username = username;
		this.amount = amount;
	}

	public Account() {
		super();
	}

	private int ID;
	private String username;
	private double amount;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

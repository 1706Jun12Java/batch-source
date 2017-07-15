package com.bank.user;

import java.sql.Timestamp;

public class Reimbursements {
	private int Reimburse_ID;
	private double amount;
	private String description;
	private String receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private String author;
	private String resolver;
	private String type;
	private String status;
	
	public int getReimburse_ID() {
		return Reimburse_ID;
	}
	public double getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public String getReceipt() {
		return receipt;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public String getAuthor() {
		return author;
	}
	public String getResolver() {
		return resolver;
	}
	public String getType() {
		return type;
	}
	public String getStatus() {
		return status;
	}
	public Reimbursements(int reimburse_ID, double amount, String description, String receipt, Timestamp submitted,
			Timestamp resolved, String author, String resolver, String type, String status) {
		super();
		Reimburse_ID = reimburse_ID;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}
	

	
	
}

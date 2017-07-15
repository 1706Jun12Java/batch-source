package com.revature.leibniz.ers.domain;

import java.io.Serializable;
import java.sql.Blob;

public class ReimbursementRequest implements Serializable {
	public static final String PENDING_STATUS = "pending";
	public static final String DENIED_STATUS = "denied";
	public static final String GRANTED_STATUS = "granted";
	
	// Final variables
	private static final long serialVersionUID = -7474343269978673104L;

	// ReimbursementRequest info:
	private int id;
	private String status;
	private double quantity;
	private Blob image;
	private int employeeID;
	
	// DEFAULT CONSTRUCTOR
	public ReimbursementRequest() {}
	
	// CONSTRUCTOR (int, String, double, Blob, int)
	public ReimbursementRequest(int id, String status, double quantity, Blob image, int employeeID) {
		this.id = id;
		this.status = status;
		this.quantity = quantity;
		this.image = image;
		this.employeeID = employeeID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ============ GETTERS =============== //
	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public double getQuantity() {
		return quantity;
	}

	public Blob getImage() {
		return image;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	
	//======== FLUENT SETTERS ===========//
	public ReimbursementRequest setId(int id) {
		this.id = id;
		return this;
	}

	public ReimbursementRequest setStatus(String status) {
		this.status = status;
		return this;
	}

	public ReimbursementRequest setQuantity(double quantity) {
		this.quantity = quantity;
		return this;
	}

	public ReimbursementRequest setImage(Blob image) {
		this.image = image;
		return this;
	}

	public ReimbursementRequest setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
		return this;
	}
	
	

}

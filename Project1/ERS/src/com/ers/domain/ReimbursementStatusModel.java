package com.ers.domain;

public class ReimbursementStatusModel {
	public ReimbursementStatusModel(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	private int id;
	private String status;
	
	public Number getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
	}

}

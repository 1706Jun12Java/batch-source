package com.bank.domain;

public class ReimbursementStatus {
	
	private int rs_id;
	private String status;

	public ReimbursementStatus() {
	}

	public ReimbursementStatus(int rs_id, String status) {
		super();
		this.rs_id = rs_id;
		this.status = status;
	}

	public int getRs_id() {
		return rs_id;
	}

	public void setRs_id(int rs_id) {
		this.rs_id = rs_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [rs_id=" + rs_id + ", status=" + status + "]";
	}
	
}

package com.revature.domain;

public class ReStatus {
	@Override
	public String toString() {
		return "ReStatus [id=" + id + ", status=" + status + "]";
	}

	private int id;
	private String status;
	
	public ReStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public ReStatus(String status) {
		super();
		this.status = status;
	}

	public int getId() {
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
	
}

package com.revature.domain;
import java.io.Serializable;

public class Account implements Serializable{
	
	private int id;
	private int bal;
	private int cid;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", bal=" + bal + ", cid=" + cid + "]";
	}

	public Account(int id, int bal, int cid) {
		super();
		this.id = id;
		this.bal = bal;
		this.cid = cid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}

	public Account() {		
	}
}

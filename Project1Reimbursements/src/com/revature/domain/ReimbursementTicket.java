package com.revature.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class ReimbursementTicket {
	private int r_id;
	private double r_amount;
	private String r_description;
	private Blob r_receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int u_id_author;
	private int u_id_resolver;
	private int r_type;
	private int r_status;
	public ReimbursementTicket() {
		super();
	}
	public ReimbursementTicket( double r_amount, String r_description, Blob r_receipt, int u_id_author, int r_type, int r_status) {
		super();
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_receipt = r_receipt;
		this.u_id_author = u_id_author;
		this.r_type = r_type;
		this.r_status = r_status;
	}
	public ReimbursementTicket( double r_amount, String r_description, Blob r_receipt, int u_id_author, int u_id_resolver, int r_type, int r_status) {
		super();
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_receipt = r_receipt;
		this.u_id_author = u_id_author;
		this.u_id_resolver = u_id_resolver;
		this.r_type = r_type;
		this.r_status = r_status;
	}
	public ReimbursementTicket( double r_amount, String r_description, Blob r_receipt, Timestamp submitted,
			Timestamp resolved, int u_id_author, int u_id_resolver, int r_type, int r_status) {
		super();
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_receipt = r_receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.u_id_author = u_id_author;
		this.u_id_resolver = u_id_resolver;
		this.r_type = r_type;
		this.r_status = r_status;
	}
	public ReimbursementTicket(int r_id, double r_amount, String r_description, Blob r_receipt, Timestamp submitted,
			Timestamp resolved, int u_id_author, int u_id_resolver, int r_type, int r_status) {
		super();
		this.r_id = r_id;
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_receipt = r_receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.u_id_author = u_id_author;
		this.u_id_resolver = u_id_resolver;
		this.r_type = r_type;
		this.r_status = r_status;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public double getR_amount() {
		return r_amount;
	}
	public void setR_amount(double r_amount) {
		this.r_amount = r_amount;
	}
	public String getR_description() {
		return r_description;
	}
	public void setR_description(String r_description) {
		this.r_description = r_description;
	}
	public Blob getR_receipt() {
		return r_receipt;
	}
	public void setR_receipt(Blob r_receipt) {
		this.r_receipt = r_receipt;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public int getU_id_author() {
		return u_id_author;
	}
	public void setU_id_author(int u_id_author) {
		this.u_id_author = u_id_author;
	}
	public int getU_id_resolver() {
		return u_id_resolver;
	}
	public void setU_id_resolver(int u_id_resolver) {
		this.u_id_resolver = u_id_resolver;
	}
	public int getR_type() {
		return r_type;
	}
	public void setR_type(int r_type) {
		this.r_type = r_type;
	}
	public int getR_status() {
		return r_status;
	}
	public void setR_status(int r_status) {
		this.r_status = r_status;
	}
	@Override
	public String toString() {
		return "ReimbursementTicket [r_id=" + r_id + ", r_amount=" + r_amount + ", r_description=" + r_description
				+ ", r_receipt=" + r_receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", u_id_author="
				+ u_id_author + ", u_id_resolver=" + u_id_resolver + ", r_type=" + r_type + ", r_status=" + r_status
				+ "]";
	}
	

}

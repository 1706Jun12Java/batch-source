package com.revature.domain;

public class Reimbursements {

	private int r_id;
	private int r_amount;
	private String r_description;
	private String r_receipt;
	private String r_submitted;
	private String r_resolved;
	private int u_id_author;
	private int u_id_resolver;
	private int rt_type;
	private int rt_status;
	
	public Reimbursements(int rId,int rAmount,String rDescription, int rType,
			int rStatus, int uIdAuthor, int uIdResolver ) {
		this.r_id = rId;
		this.r_amount = rAmount;
		this.r_description = rDescription;
		this.rt_type = rType;
		this.rt_status = rStatus;
		this.u_id_author = uIdAuthor;
		this.u_id_resolver = uIdResolver;
	}
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getR_amount() {
		return r_amount;
	}
	public void setR_amount(int r_amount) {
		this.r_amount = r_amount;
	}
	public String getR_description() {
		return r_description;
	}
	public void setR_description(String r_description) {
		this.r_description = r_description;
	}
	public String getR_receipt() {
		return r_receipt;
	}
	public void setR_receipt(String r_receipt) {
		this.r_receipt = r_receipt;
	}
	public String getR_submitted() {
		return r_submitted;
	}
	public void setR_submitted(String r_submitted) {
		this.r_submitted = r_submitted;
	}
	public String getR_resolved() {
		return r_resolved;
	}
	public void setR_resolved(String r_resolved) {
		this.r_resolved = r_resolved;
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
	public int getRt_type() {
		return rt_type;
	}
	public void setRt_type(int rt_type) {
		this.rt_type = rt_type;
	}
	public int getRt_status() {
		return rt_status;
	}
	public void setRt_status(int rt_status) {
		this.rt_status = rt_status;
	}

	@Override
	public String toString() {
		return "Id: " + r_id + ", Amount: " + r_amount + ",Description: " + r_description + ", Receipt: " + r_receipt
				+ ", Submitted: " + r_submitted + ", Resolved: " + r_resolved + ", Author: " + u_id_author
				+ ", Resolver: " + u_id_resolver + ", Type: " + rt_type + ", Status: " + rt_status;
	}
}

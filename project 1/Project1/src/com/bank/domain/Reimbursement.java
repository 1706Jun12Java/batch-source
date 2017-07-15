package com.bank.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
	private int r_id;
	private double amount;
	private String description;
	private Blob file;
	private Timestamp submitted;
	private Timestamp resolved;
	private User u_id;
	private User uu_id;
	private ReimbursementType t_id;
	private ReimbursementStatus s_id;

	public Reimbursement() {
	}

	public Reimbursement(int r_id, double amount, String description, Timestamp submitted, Timestamp resolved,
			User u_id, User uu_id, ReimbursementType t_id, ReimbursementStatus s_id) {
		super();
		this.r_id = r_id;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.u_id = u_id;
		this.uu_id = uu_id;
		this.t_id = t_id;
		this.s_id = s_id;
	}

	public Reimbursement(double amount, String description, Timestamp submitted, Timestamp resolved, User u_id,
			ReimbursementType t_id, ReimbursementStatus s_id) {
		super();
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.u_id = u_id;
		this.t_id = t_id;
		this.s_id = s_id;
	}

	public Reimbursement(int r_id, double amount, String description, Timestamp submitted, Timestamp resolved,
			ReimbursementType t_id, ReimbursementStatus s_id) {
		super();
		this.r_id = r_id;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.t_id = t_id;
		this.s_id = s_id;
	}

	public Reimbursement(int r_id, double amount, String description, Timestamp submitted,
			Timestamp resolved, User u_id, ReimbursementType t_id, ReimbursementStatus s_id) {
		super();
		this.r_id = r_id;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.u_id = u_id;
		this.t_id = t_id;
		this.s_id = s_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
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

	public User getU_id() {
		return u_id;
	}

	public void setU_id(User u_id) {
		this.u_id = u_id;
	}

	public ReimbursementType getT_id() {
		return t_id;
	}

	public void setT_id(ReimbursementType t_id) {
		this.t_id = t_id;
	}

	public ReimbursementStatus getS_id() {
		return s_id;
	}

	public void setS_id(ReimbursementStatus s_id) {
		this.s_id = s_id;
	}

	public User getUu_id() {
		return uu_id;
	}

	public void setUu_id(User uu_id) {
		this.uu_id = uu_id;
	}

	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", amount=" + amount + ", description=" + description + ", file=" + file
				+ ", submitted=" + submitted + ", resolved=" + resolved + ", u_id=" + u_id + ", t_id=" + t_id
				+ ", s_id=" + s_id + "]";
	}
	
}

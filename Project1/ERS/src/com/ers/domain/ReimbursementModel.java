package com.ers.domain;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

public class ReimbursementModel {
	
	public ReimbursementModel(int id, BigDecimal amount, String description, Blob receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, int typeId, int statusId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.typeId = typeId;
		this.statusId = statusId;
	}
	
	private int id;
	private Number amount;
	private String description;
	private Blob receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int authorId;
	private int resolverId;
	private int typeId;
	private int statusId;
	
	public Number getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Number getAmount() {
		return amount;
	}
	public void setAmount(Number amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
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
	public Number getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Number getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	public Number getType() {
		return typeId;
	}
	public void setType(int typeId) {
		this.typeId = typeId;
	}
	public Number getStatus() {
		return statusId;
	}
	public void setStatus(int statusId) {
		this.statusId = statusId;
	}
	@Override
	public String toString() {
		return "ErsReimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", type=" + typeId + ", status=" + statusId + "]";
	}

}

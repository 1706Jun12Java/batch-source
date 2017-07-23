package com.hers.domain;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="HERS_REIMBURSEMENTS")
public class ReimbursementModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7607504890004882447L;

	public ReimbursementModel(int id, BigDecimal amount, String description, InputStream receipt, Timestamp submitted,
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
		
	public ReimbursementModel() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reimbursementSequence")
	@SequenceGenerator(allocationSize=1, name="reimbursementSequence", sequenceName="REIMBURSEMENT_SEQ")
	@Column(name="R_ID")
	private int id;
	
	@Column(name="R_AMOUNT")
	private BigDecimal amount;
	
	@Column(name="R_DESCRIPTION")
	private String description;
	
	@Column(name="R_RECEIPT")
	private InputStream receipt;
	
	@Column(name="R_SUBMITTED")
	private Timestamp submitted;
	
	@Column(name="R_RESOLVED", nullable=true, columnDefinition = "Timestamp default null")
	private Timestamp resolved;
	
	@Column(name="U_ID_AUTHOR")
	private int authorId;
	
	@Column(name="U_ID_RESOLVER", nullable=true, columnDefinition = "int default null")
	private int resolverId;
	
	@Column(name="RT_TYPE")
	private int typeId;
	
	@Column(name="RT_STATUS", nullable=false, columnDefinition = "int default 1")
	private int statusId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public InputStream getReceipt() {
		return receipt;
	}
	public void setReceipt(InputStream receipt) {
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
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	public int getType() {
		return typeId;
	}
	public void setType(int typeId) {
		this.typeId = typeId;
	}
	public int getStatus() {
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

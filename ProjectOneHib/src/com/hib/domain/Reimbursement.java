package com.hib.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="REIMBURSEMENT")
public class Reimbursement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2003295395081891050L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reimbursementSequence")
	@SequenceGenerator(allocationSize=1, name="reimbursementSequence", sequenceName="REIMBURSEMENT_SEQ")
	@Column(name="REIMBURSE_ID")
	private int id;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="RECEIPT")
	private Blob receipt;
	
	@Column(name="SUBMITTED")
	private Timestamp submitted;
	
	@Column(name="RESOLVED")
	private Timestamp resolved;
	
	@ManyToOne
	@JoinColumn(name="U_ID_AUTHOR")
	private Users authorId;
	
	@ManyToOne
	@JoinColumn(name="U_ID_RESOLVER")
	private Users resolverId;
	
	@ManyToOne
	@JoinColumn(name="RT_ID")
	private ReimbursementType type;
	
	@ManyToOne
	@JoinColumn(name = "RS_ID")
	private ReimbursementStatus status;

	public Reimbursement(double amount, String description, Blob receipt, Timestamp submitted, Timestamp resolved,
			Users authorId, Users resolverId, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Users getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Users authorId) {
		this.authorId = authorId;
	}

	public Users getResolverId() {
		return resolverId;
	}

	public void setResolverId(Users resolverId) {
		this.resolverId = resolverId;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", type=" + type + ", status=" + status + "]";
	}
	
	
}

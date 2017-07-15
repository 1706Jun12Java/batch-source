package com.revature.domain;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	private int id;
	private double amount;
	private String description;
	private InputStream receipe;
	private Date submited;
	private Date resolved;
	private int author;
	private int resolver;
	private String resolverName;
	private int type;
	private String typeName;
	private int status;
	private String statusName;
	
	public Reimbursement(int id, double amount, String description, Date submited, Date resolved,
			int author, int resolver, String resolverName, int type, String typeName, int status, String statusName) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submited = submited;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.resolverName = resolverName;
		this.type = type;
		this.typeName = typeName;
		this.status = status;
		this.statusName = statusName;
	}
	
	public Reimbursement(double amount, String description, InputStream receipe,
			int author, int type) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipe = receipe;
		this.author = author;
		this.type = type;
	}
	
	public Reimbursement(int id, double amount, String description, Date submited, Date resolved,
			 String typeName, String statusName) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submited = submited;
		this.resolved = resolved;
		this.typeName = typeName;
		this.statusName = statusName;
	}
	
	public Reimbursement(int id, double amount, String description, Date submited, Date resolved,
			 String typeName, String statusName, String resolverName) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submited = submited;
		this.resolved = resolved;
		this.typeName = typeName;
		this.statusName = statusName;
		this.resolverName = resolverName;
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
	public InputStream getReceipe() {
		return receipe;
	}
	public void setReceipe(InputStream receipe) {
		this.receipe = receipe;
	}
	public Date getSubmited() {
		return submited;
	}
	public void setSubmited(Date submited) {
		this.submited = submited;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public String getResolverName() {
		return resolverName;
	}
	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}

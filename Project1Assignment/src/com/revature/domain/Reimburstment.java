package com.revature.domain;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class Reimburstment {

	private int id;
	private double amount;
	private String description;
	private String picture;
	private String submmitted;
	private String resolved;
	private E_User submittedBy;
	private E_User handledBy;
	private String type;
	private String status;
	public Reimburstment(int id, double amount, String description, String picture,E_User submittedBy,E_User handledBy, Timestamp submmitted,
			Timestamp resolved, String type, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.picture = picture;
		this.submittedBy = submittedBy;
		this.handledBy = handledBy;
		this.submmitted = this.timeStampToString(submmitted);
		this.resolved = this.timeStampToString(resolved);
		this.type = type;
		this.status = status;
	}
	
	public Reimburstment(double amount, String description, String picture, E_User submittedBy,E_User handledBy,Timestamp submmitted,
			Timestamp resolved, String type, String status) {
		super();
		this.amount = amount;
		this.description = description;
		this.picture = picture;
		this.submmitted = this.timeStampToString(submmitted);
		this.submittedBy = submittedBy;
		this.handledBy = handledBy;
		this.resolved = this.timeStampToString(resolved);
		this.type = type;
		this.status = status;
	}
	
	private String timeStampToString(Timestamp stamp){
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
		if(stamp == null){
			return null;
		}
		return dateFormat.format(stamp);
	}
	public Reimburstment() {
		// TODO Auto-generated constructor stub
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSubmitted() {
		return submmitted;
	}

	public void setSubmitted(Timestamp submmitted) {
		this.submmitted = this.timeStampToString(submmitted);
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = this.timeStampToString(resolved);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimburstment [id=" + id + ", amount=" + amount + ", description=" + description + ", picture="
				+ picture + ", submmitted=" + submmitted + ", resolved=" + resolved + ", type=" + type + ", status="
				+ status + "]";
	}

	public E_User getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(E_User submittedBy) {
		this.submittedBy = submittedBy;
	}

	public E_User getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(E_User handledBy) {
		this.handledBy = handledBy;
	}
	
}

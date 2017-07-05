package com.revature.bank.domain;

import java.sql.Date;

public class Transaction {
	
	private int tranID;
	private int acID;
	private Date tranDate;
	private String actionType;
	private Double beforeBal;
	private Double afterBal;
	
	public Transaction(int tranID, int acID, Date tranDate, String actionType, Double beforeBal, Double afterBal) {
		super();
		this.tranID = tranID;
		this.acID = acID;
		this.tranDate = tranDate;
		this.actionType = actionType;
		this.beforeBal = beforeBal;
		this.afterBal = afterBal;
	}
	public int getTranID() {
		return tranID;
	}
	public int getAcID() {
		return acID;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public String getActionType() {
		return actionType;
	}
	public Double getBeforeBal() {
		return beforeBal;
	}
	public Double getAfterBal() {
		return afterBal;
	}
	@Override
	public String toString() {
		return "Transaction [tranID= " + tranID + " tranDate= " + tranDate+ ", "
				+ actionType + ", before= " + beforeBal + " , after " + afterBal + "]";
	}
}

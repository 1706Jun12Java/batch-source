package com.revature.domain;

import java.math.BigDecimal;

public class BankAccountInfo {
	public BankAccountInfo(int userId, int bankAccountId, BigDecimal bankAccountBalance, BankLoginInfo bankLoginInfo) {
		super();
		this.userId = userId;
		this.bankAccountId = bankAccountId;
		this.bankAccountBalance = bankAccountBalance;
		this.bankLoginInfo = bankLoginInfo;
	}
	public BankAccountInfo(int userId, int bankAccountId, BigDecimal bankAccountBalance) {
		super();
		this.userId = userId;
		this.bankAccountId = bankAccountId;
		this.bankAccountBalance = bankAccountBalance;
	}
	
	public BankAccountInfo(int userId){
		super();
		this.userId = userId;
	}
	
	public BankAccountInfo(int userId, int bankAccountId){
		super();
		this.userId = userId;
		this.bankAccountId = bankAccountId;
	}
	
	private int userId;
	private int bankAccountId;
	private BigDecimal bankAccountBalance;
	private BankLoginInfo bankLoginInfo;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public BigDecimal getBankAccountBalance() {
		return bankAccountBalance;
	}
	public void setBankAccountBalance(BigDecimal bankAccountBalance) {
		this.bankAccountBalance = bankAccountBalance;
	}
	@Override
	public String toString() {
		return "BankAccountInfo [userId=" + userId + ", bankAccountId=" + bankAccountId + ", bankAccountBalance="
				+ bankAccountBalance]";
	}
	public BankLoginInfo getBankLoginInfo() {
		return bankLoginInfo;
	}
	public void setBankLoginInfo(BankLoginInfo bankLoginInfo) {
		this.bankLoginInfo = bankLoginInfo;
	}

}

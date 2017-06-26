package com.revature.domain;

public class BankAccount {

		private int bankAccountId;
		private double balance;
		public BankAccount() {
			super();
			// TODO Auto-generated constructor stub
		}
		public BankAccount(double balance) {
			super();
			this.balance = balance;
		}
		public BankAccount(int bankAccountId, double balance) {
			super();
			this.bankAccountId = bankAccountId;
			this.balance = balance;
		}
		public int getBankAccountId() {
			return bankAccountId;
		}
		public void setBankAccountId(int bankAccountId) {
			this.bankAccountId = bankAccountId;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			return "BankAccount [bankAccountId=" + bankAccountId + ", balance=" + balance + "]";
		}
		
		
		
		

}

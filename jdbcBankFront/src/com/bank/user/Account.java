package com.bank.user;

public class Account {
    private int accountID;
    private double balance;
    private int bank_user_ID;

    public int getBank_user_ID() {
        return bank_user_ID;
    }

    public void setBank_user_ID(int bank_user_ID) {
        this.bank_user_ID = bank_user_ID;
    }

    public Account(double balance, int bank_user_id) {
        this.balance = balance;
        this.bank_user_ID = bank_user_id;
    }

    public Account(int accountID, double balance, int bank_user_ID) {
        this.accountID = accountID;
        this.balance = balance;
        this.bank_user_ID = bank_user_ID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", balance=" + balance +
                ", bank_user_ID=" + bank_user_ID +
                '}';
    }
}

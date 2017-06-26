package com.jdbchw.domain;

import java.sql.Date;

public class Transaction {

    private int transID;
    private Date date;
    private int amount;
    private String transDescription;

    public Transaction(Date date, int amount, String transDescription) {
        this.date = date;
        this.amount = amount;
        this.transDescription = transDescription;
    }

    public Transaction(int transID, Date date, int amount, String transDescription) {
        this.transID = transID;
        this.date = date;
        this.amount = amount;
        this.transDescription = transDescription;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransDescription() {
        return transDescription;
    }

    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transID=" + transID +
                ", date=" + date +
                ", amount=" + amount +
                ", transDescription='" + transDescription + '\'' +
                '}';
    }
}

package com.revature.models;

import java.sql.Blob;
import java.sql.Timestamp;


public class Reimbursement
{
    private int Id;
    private double amount;
    private String description;
    private Blob receipt;
    private Timestamp submitted;
    private Timestamp resolved;

    private int author;
    private int resolver;
    private int reimbursementType;
    private int reimbursementStatus;

    public Reimbursement(double amount, String description, Timestamp submitted, int author, int reimbursementType, int reimbursementStatus)
    {
        this.amount = amount;
        this.description = description;
        this.submitted = submitted;
        this.author = author;
        this.reimbursementType = reimbursementType;
        this.reimbursementStatus = reimbursementStatus;
    }

    public Reimbursement(double amount, String description, Blob receipt, Timestamp submitted, int author, int reimbursementType, int reimbursementStatus)
    {
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.submitted = submitted;
        this.author = author;
        this.reimbursementType = reimbursementType;
        this.reimbursementStatus = reimbursementStatus;
    }

    public Reimbursement(int id, double amount, String description, Blob receipt, Timestamp submitted, Timestamp resolved, int author, int resolver, int reimbursementType, int reimbursementStatus)
    {
        Id = id;
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.submitted = submitted;
        this.resolved = resolved;
        this.author = author;
        this.resolver = resolver;
        this.reimbursementType = reimbursementType;
        this.reimbursementStatus = reimbursementStatus;
    }

    @Override
    public String toString()
    {
        return "Reimbursement{" +
                "Id=" + Id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", author=" + author +
                ", resolver=" + resolver +
                ", ReimbursementType=" + reimbursementType +
                ", ReimbursementStatus=" + reimbursementStatus +
                '}';
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Blob getReceipt()
    {
        return receipt;
    }

    public void setReceipt(Blob receipt)
    {
        this.receipt = receipt;
    }

    public Timestamp getSubmitted()
    {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted)
    {
        this.submitted = submitted;
    }

    public Timestamp getResolved()
    {
        return resolved;
    }

    public void setResolved(Timestamp resolved)
    {
        this.resolved = resolved;
    }

    public int getAuthor()
    {
        return author;
    }

    public void setAuthor(int author)
    {
        this.author = author;
    }

    public int getResolver()
    {
        return resolver;
    }

    public void setResolver(int resolver)
    {
        this.resolver = resolver;
    }

    public int getReimbursementType()
    {
        return reimbursementType;
    }

    public void setReimbursementType(int reimbursementType)
    {
        this.reimbursementType = reimbursementType;
    }

    public int getReimbursementStatus()
    {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(int reimbursementStatus)
    {
        this.reimbursementStatus = reimbursementStatus;
    }
}

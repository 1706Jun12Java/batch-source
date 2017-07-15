package com.revature.models;


public class ReimbursementType
{
    private int id;
    private String type;

    public ReimbursementType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ReimbursementType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}

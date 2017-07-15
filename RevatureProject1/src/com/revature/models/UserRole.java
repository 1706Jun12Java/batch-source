package com.revature.models;


public class UserRole
{
    private int id;
    private String role;

    public UserRole(String role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
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

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}

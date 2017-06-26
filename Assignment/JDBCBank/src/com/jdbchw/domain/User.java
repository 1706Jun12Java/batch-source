package com.jdbchw.domain;

import java.util.List;

public class User {

    private int userID;
    private String username;
    private String password;
    private String email;
    private int superUser;
//    private List<Transaction> transactions;

    public User(String username, String password, String email, int superUser) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.superUser = superUser;
    }

    public User(int userID, String username, String email, int superUser) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.superUser = superUser;
    }

    public User(int userID, String username, String password, String email, int superUser) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.superUser = superUser;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSuperUser() {
        return superUser;
    }

    public void setSuperUser(int superUser) {
        this.superUser = superUser;
    }

//    public List<Transaction> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<Transaction> transactions) {
//        this.transactions = transactions;
//    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", superUser=" + superUser +
                '}';
    }
}

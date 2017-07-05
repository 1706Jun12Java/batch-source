package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.bankapp.dao.Bank_UserDao;
import com.bankapp.dao.Bank_UserDaoImpl;
import com.bankapp.util.App;

public class TestClass {

	public TestClass() {
		
	}
	
	public static void main (String[] args) throws IOException, SQLException{
		System.out.println(checkUser("mzaman","1234")); // Test values
	}
	
	
	
	public static String checkUser(String un,String pw) throws IOException, SQLException 
    {
    	
    	App.getConnectionFromFile("connection.properties");
		Bank_UserDao u1 = new Bank_UserDaoImpl();
		System.out.println((u1.getBank_UserByID(un,pw)).toString());
		int userID = u1.getBank_UserByID(un,pw).userIDInt();
		String newUserID = Integer.toString(userID);
		return newUserID;
    }   
	
}

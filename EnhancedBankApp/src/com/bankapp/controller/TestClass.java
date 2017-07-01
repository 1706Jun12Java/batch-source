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
	
	
	
	public static boolean checkUser(String un,String pw) 
    {
     boolean st =false;
     try{

    	App.getConnectionFromFile("connection.properties");
 		Bank_UserDao u1 = new Bank_UserDaoImpl();
 		System.out.println((u1.getBank_UserByID(un,pw)).toString());
 		int userID = u1.getBank_UserByID(un,pw).userIDInt();
        if (userID>0){
       	st = true;  
        }
       
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   

}

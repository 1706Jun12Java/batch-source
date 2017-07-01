package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.bankapp.dao.Bank_UserDao;
import com.bankapp.dao.Bank_UserDaoImpl;
import com.bankapp.util.App;

public class TestClass {

	public TestClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) throws IOException, SQLException{
		/*@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		System.out.println("Username: ");
		String un = sc.nextLine(); 
		
		System.out.println("Password: ");
		String pw = sc.nextLine(); 
		
		App.getConnectionFromFile("connection.properties");
		Bank_UserDao u1 = new Bank_UserDaoImpl();
		System.out.println((u1.getBank_UserByID(un,pw)).toString());
		int userID = u1.getBank_UserByID(un,pw).userIDInt();
		System.out.println(userID);*/
		//viewUserMenu(userID);
		
		System.out.println(checkUser("mzaman","1234"));
	}
	
	
	
	public static boolean checkUser(String un,String pw) 
    {
     boolean st =false;
     try{

    	App.getConnectionFromFile("connection.properties");
 		Bank_UserDao u1 = new Bank_UserDaoImpl();
 		System.out.println((u1.getBank_UserByID(un,pw)).toString());
 		int userID = u1.getBank_UserByID(un,pw).userIDInt();
       /* PreparedStatement ps =con.prepareStatement
                            ("SELECT USERNAME, PASSWORD_ FROM BANK_USER WHERE USERNAME=? and PASSWORD_=?");
        ps.setString(1, un);
        ps.setString(2, pw);
        ResultSet rs =ps.executeQuery();*/
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

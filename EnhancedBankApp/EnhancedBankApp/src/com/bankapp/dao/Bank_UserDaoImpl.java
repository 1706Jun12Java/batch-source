package com.bankapp.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bankapp.domain.Bank_User;
import com.bankapp.util.App;




public class Bank_UserDaoImpl implements Bank_UserDao {
	

	public Bank_UserDaoImpl() {
	}

	public Bank_User getBank_UserByID(String un, String pw) {
		Bank_User bu = null;
		try(Connection con = App.getConnectionFromFile()){
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME=? AND PASSWORD_=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				int user_id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD_");
				String fname = rs.getString("F_NAME");
				String lname = rs.getString("L_NAME");
				int superUser = rs.getInt("IS_SUPERUSER");
				bu = new Bank_User(user_id,username,password,fname,lname,superUser);
				}
			
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bu;
	}
	
	

	public static void createAccount(){	
		System.out.println("============ ACCOUNT CREATION PAGE =========");
		
		try(Connection con = App.getConnectionFromFile()){
			Scanner sc = new Scanner (System.in); 
			System.out.println("Choose a username: ");
			String username = sc.nextLine();
			
			System.out.println("Enter ID: ");
			int user_id = sc.nextInt(); sc.nextLine();
			
			System.out.println("Choose a password: ");
			String password = sc.nextLine(); 
			
			System.out.println("First Name: ");
			String fname = sc.nextLine(); 
			
			System.out.println("Last Name: ");
			String lname = sc.nextLine(); 
			
			System.out.println("Are you an admin/superuser? (1 for yes, 0 for no)");
			int superuser = sc.nextInt(); 
			
			String sql = "INSERT INTO BANK_USER (USER_ID,F_NAME,L_NAME,USERNAME,PASSWORD_,IS_SUPERUSER)"
					+ " VALUES(?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.setInt(6, superuser);
			pstmt.executeUpdate(); 
			
			System.out.println("Account successfully created.");
			
			sc.close();
		}catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
	
	
	public static void viewAllUsers(){	
		try(Connection con = App.getConnectionFromFile()){
			
			String sql = "SELECT * FROM BANK_USER";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				int u = rs.getInt("USER_ID");
				String fn = rs.getString("F_NAME");
				String ln = rs.getString("L_NAME");
				String un = rs.getString("USERNAME");
				String pw = rs.getString("PASSWORD_"); 
				int ss = rs.getInt("IS_SUPERUSER");
				System.out.println("USER ID: " + u + " FIRST NAME: " + fn + " LAST NAME: " + ln + " USERNAME " + un + " PASSWORD: " + pw + " SUPER STATUS: " + ss );
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
	}
	
	public static void deleteAllUsers(){	
		try(Connection con = App.getConnectionFromFile()){
			String sql = "DELETE FROM BANK_USER";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("All users have been deleted from the system.");
	
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
				
	}
	
	public static void updateFirstName(){	
		
		try(Connection con = App.getConnectionFromFile()){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (System.in); 
			System.out.println("User ID of the account you want to change: ");
			int userid = sc.nextInt(); 
			sc.nextLine();
			System.out.println("Update the first name to: ");
			String newFirstName = sc.nextLine(); 
			
			String sql = "UPDATE BANK_USER SET F_NAME=? WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, newFirstName);
			pstmt.setInt(2, userid);
 			pstmt.executeQuery(); 
 			
 			System.out.println("Your account has been successfully updated :)");
				
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void updateLastName(){
		
		try(Connection con = App.getConnectionFromFile()){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (System.in); 
			System.out.println("User ID of the account you want to change: ");
			int userid = sc.nextInt(); 
			sc.nextLine();
			System.out.println("Update the last name to: ");
			String newLastName = sc.nextLine(); 
			
			String sql = "UPDATE BANK_USER SET L_NAME=? WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, newLastName);
			pstmt.setInt(2, userid);
 			pstmt.executeQuery(); 
 			
 			System.out.println("Your account has been successfully updated :)");
				
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
/*	

CREATE OR REPLACE PROCEDURE updateDBUSER(
	   p_userid IN BANK_USER.USER_ID%TYPE,
	   p_username IN BANK_USER.USERNAME%TYPE)
		IS
BEGIN
		UPDATE BANK_USER SET USERNAME = p_username where USER_ID = p_userid;
		COMMIT;
END;*/
	
	
	public static void updateUsername(){
		
		try(Connection con = App.getConnectionFromFile()){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (System.in); 
			System.out.println("User ID of the account you want to change: ");
			int userid = sc.nextInt(); 
			sc.nextLine();
			System.out.println("Update the username to: ");
			String newUserName = sc.nextLine(); 
			
			CallableStatement cs = null;
			String sql = "{CALL UPDATEDDBUSER(?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, userid);
			cs.setString(2, newUserName);
			
 			cs.executeQuery(); 
 			
 			System.out.println("Your account has been successfully updated :)");
				
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	public static void updatePassword(){	
		
		try(Connection con = App.getConnectionFromFile()){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (System.in); 
			System.out.println("User ID of the account you want to change: ");
			int userid = sc.nextInt(); 
			sc.nextLine();
			System.out.println("Update the password to: ");
			String newPassword = sc.nextLine(); 
			
			String sql = "UPDATE BANK_USER SET PASSWORD_=? WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, userid);
 			pstmt.executeQuery(); 
 			
 			System.out.println("Your account has been successfully updated :)");
				
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void updateSuperStatus(){	
		
		try(Connection con = App.getConnectionFromFile()){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (System.in); 
			System.out.println("User ID of the account you want to change: ");
			int userid = sc.nextInt(); 
			sc.nextLine();
			System.out.println("Update the super status to: ");
			int newSS = sc.nextInt(); 
			
			String sql = "UPDATE BANK_USER SET IS_SUPERUSER=? WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, newSS);
			pstmt.setInt(2, userid);
 			pstmt.executeQuery(); 
 			
 			System.out.println("Your account has been successfully updated :)");
				
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}

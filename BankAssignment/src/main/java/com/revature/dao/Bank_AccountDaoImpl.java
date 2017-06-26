package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.BankAssignment.App;
import com.revature.domain.Bank_Account;
import com.revature.domain.Bank_User;

@SuppressWarnings("unused")
public class Bank_AccountDaoImpl implements Bank_AccountDao{

	public Bank_AccountDaoImpl() {
	}

	public List<Bank_Account> getBank_AccountByID() {
		return null;
	}
	
public static void viewAccountBalance(int uid){	
	
	try(Connection con = App.getConnectionFromFile("connection.properties")){
		
		String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, uid);
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()){	;
			double balance = rs.getFloat("BALANCE");
			System.out.println("Your balance is: $" + balance);
			}
	}catch (SQLException e){
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
			
	
}

public static void deleteEmptyAccount(int uid){

	try(Connection con = App.getConnectionFromFile("connection.properties")){
		
		String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, uid);
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()){	
			double balance = rs.getFloat("BALANCE");
			System.out.println("Your balance is: $" + balance);
			if(balance < 1){
				System.out.println("Since you're balance is empty, your account is being deleted...");
				String sqlstmt = "DELETE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
				PreparedStatement ps =con.prepareStatement(sqlstmt);
				ps.setInt(1, uid);
				ResultSet r = ps.executeQuery();
				System.out.println("Deletion complete");
			} else {
				System.out.println("Your balance is >0, your account can not be deleted.");
			}
			}
	}catch (SQLException e){
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
}

public static void depositMoney(int uid){
	
try(Connection con = App.getConnectionFromFile("connection.properties")){
		
		System.out.println("How much money would you like to deposit?");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double depositAmount = sc.nextFloat(); 
		
		String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, uid);
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()){	
			double balance = rs.getFloat("BALANCE");
			depositAmount = balance + depositAmount;
			}
		
		String sq = "UPDATE BANK_ACCOUNT SET BALANCE=? WHERE ACCOUNT_USER_ID=?"; 
		PreparedStatement pstm = con.prepareStatement(sq);
		pstm.setDouble(1, depositAmount);
		pstm.setInt(2, uid);
		ResultSet r = pstm.executeQuery();
		System.out.println("Your balance has been adjusted.");

	}catch (SQLException e){
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}

}

public static void withdrawMoney(int uid) throws OverdraftException{
try(Connection con = App.getConnectionFromFile("connection.properties")){
		
		System.out.println("How much money would you like to withdraw?");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double depositAmount = sc.nextFloat(); 
		
		String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, uid);
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()){	
			double balance = rs.getFloat("BALANCE");
			depositAmount = balance - depositAmount;
			if (depositAmount <0){
				throw new OverdraftException("This is not valid!");
			}
			}
		
		String sq = "UPDATE BANK_ACCOUNT SET BALANCE=? WHERE ACCOUNT_USER_ID=?"; 
		PreparedStatement pstm = con.prepareStatement(sq);
		pstm.setDouble(1, depositAmount);
		pstm.setInt(2, uid);
		ResultSet r = pstm.executeQuery();
		System.out.println("Your balance has been adjusted.");

	}catch (SQLException e){
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}


}

}

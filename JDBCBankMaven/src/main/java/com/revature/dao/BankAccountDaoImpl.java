package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.domain.BankAccount;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	public BankAccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BankAccount> getBankAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANKACCOUNT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				int bankAccountId = rs.getInt("BANK_ID");
				double balance = rs.getDouble("BALANCE");
				
				accounts.add(new BankAccount(bankAccountId,balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return accounts;
	}

	@Override
	public List<BankAccount> getBankAccountsByUser(User user) {
		UserDaoImpl userDao = new UserDaoImpl();
		User test=null;
		//check if account is good
		if(user!=null)
			test = userDao.userLogin(user.getUsername(), user.getPassword());
		else
			return null;
		if(test==null)
			return null;
		List<BankAccount> accounts = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANKACCOUNT WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,test.getUserId());
			ResultSet rs = pstmt.executeQuery();
			accounts = new ArrayList<BankAccount>();
			while (rs.next()){
				int bankAccountId = rs.getInt("BANK_ID");
				double balance = rs.getDouble("BALANCE");
				
				accounts.add(new BankAccount(bankAccountId,balance));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return accounts;
		
	}

	@Override
	public BankAccount getBankAccountById(int id) {
		BankAccount acc=null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANK_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				double balance = rs.getDouble("BALANCE");
				
				acc = new BankAccount(id,balance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return acc;
	}

	@Override
	public int createBankAccount(User creator) {
		UserDaoImpl userDao = new UserDaoImpl();
		User test=null;
		int bankCreate =0;
		//check if account is good
		if(creator!=null)
			test = userDao.userLogin(creator.getUsername(), creator.getPassword());
		else
			return 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			
			con.setAutoCommit(false);
			String sql = "INSERT INTO BANKACCOUNT (BALANCE,USER_ID) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,0);
			pstmt.setInt(2,test.getUserId());
			bankCreate = pstmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bankCreate;
		
		
	}

	@Override
	public int withdrawFromBank(User creator) {
		UserDaoImpl userDao = new UserDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		User test=null;
		int withdrawn =0;
		//check if account is good
		if(creator!=null)
			test = userDao.userLogin(creator.getUsername(), creator.getPassword());
		else
			return 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			
			con.setAutoCommit(false);
			
			List<BankAccount> accs = bankDao.getBankAccountsByUser(test);
			for(BankAccount u : accs){
				System.out.println(u);
			}
			
			System.out.println("Enter the bankid of the acount to withdraw from: ");
			Scanner scan = new Scanner(System.in);
			
			String sql = "UPDATE BANKACCOUNT "
					+ "SET BALANCE = BALANCE - ?"
					+ "WHERE BANK_ID =?";
			int bid=scan.nextInt();
			System.out.println("How much do you want to withdraw form that account?");
			int withdraw = scan.nextInt();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,withdraw);
			pstmt.setInt(2,bid);
			withdrawn = pstmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			System.out.println("Withdrawal done");
			accs = bankDao.getBankAccountsByUser(test);
			for(BankAccount u : accs){
				System.out.println(u);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return withdrawn;
	}

	@Override
	public int depositToBank(User creator) {
		UserDaoImpl userDao = new UserDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		User test=null;
		int withdrawn =0;
		//check if account is good
		if(creator!=null)
			test = userDao.userLogin(creator.getUsername(), creator.getPassword());
		else
			return 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			
			con.setAutoCommit(false);
			
			List<BankAccount> accs = bankDao.getBankAccountsByUser(test);
			for(BankAccount u : accs){
				System.out.println(u);
			}
			
			System.out.println("Enter the bankid of the acount to deposit to: ");
			Scanner scan = new Scanner(System.in);
			
			String sql = "UPDATE BANKACCOUNT "
					+ "SET BALANCE = BALANCE + ?"
					+ "WHERE BANK_ID =?";
			int bid=scan.nextInt();
			System.out.println("How much do you want to deposit to that account?");
			int withdraw = scan.nextInt();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,withdraw);
			pstmt.setInt(2,bid);
			withdrawn = pstmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			System.out.println("Deposit done");
			accs = bankDao.getBankAccountsByUser(test);
			for(BankAccount u : accs){
				System.out.println(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return withdrawn;
	}
}

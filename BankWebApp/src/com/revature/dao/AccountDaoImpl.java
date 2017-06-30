package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.revature.domain.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl extends HttpServlet implements AccountDao{

	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertAccount() {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "INSERT INTO ACCOUNT"
				+ "(ACCID,BALANCE,CUSTID)"
				+ "VALUES (5,37800,4)";
			Statement statement = con.createStatement();			
			System.out.println(sql);			
			statement.executeUpdate(sql);
			System.out.println("Record is inserted into Account table!");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public List<Account> getAccounts() {
		List<Account> al = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ACCOUNT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("ACCID");
				int bal = rs.getInt("BALANCE");
				int cid = rs.getInt("CUSTID");				
								
				al.add(new Account(id,bal,cid));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return al;		
	}
}

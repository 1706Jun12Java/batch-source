package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.jdbcbank.domain.*; 
import com.jdbcbank.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	public TransactionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTransaction(Transaction t) { 
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "INSERT INTO TRANSACTION(ACCOUNT_ID, TRANSACTION_TYPE, TRANSACTION_AMT, TRANSACTION_DATE) VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,t.getAccount_id()); 
			pstmt.setString(2,t.getTransaction_type()); 
			pstmt.setFloat(3,t.getTransaction_amt()); 
			pstmt.setDate(4, (Date) t.getTransaction_date());
			pstmt.executeUpdate(sql);  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}   
	}

	@Override
	public List<Transaction> getTransaction(Account a){
		List<Transaction> listTransac = new ArrayList<Transaction>();
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM TRANSACTION WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a.getAccount_id()); 
			ResultSet rs = pstmt.executeQuery(sql); 
			while (rs.next()){
				int id = rs.getInt("TRANSACTION_ID");
				int account_id = rs.getInt("ACCOUNT_ID");
				String transcation_type = rs.getString("TRANSCATION_TYPE"); 
				float transcation_amt = rs.getFloat("TRANSCATION_AMT");
				Date transcation_date = rs.getDate("TRANSCATION_DATE");
				listTransac.add(new Transaction(id, account_id, transcation_type, transcation_amt, transcation_date));
			}  
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e1) { 
			e1.printStackTrace();
		}
		return listTransac;  
	} 
}

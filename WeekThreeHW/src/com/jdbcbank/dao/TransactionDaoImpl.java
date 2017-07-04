package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.*; 
import java.time.LocalDate;
import java.util.*;

import com.jdbcbank.domain.*; 
import com.jdbcbank.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	public TransactionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTransaction(Transaction t) throws SQLException, IOException { 
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "INSERT INTO TRANSACTION(ACCOUNT_ID, TRANSACTION_TYPE, TRANSACTION_AMT, TRANSACTION_DATE) VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,t.getAccount_id()); 
			pstmt.setString(2,t.getTransaction_type()); 
			pstmt.setFloat(3,t.getTransaction_amt()); 
			pstmt.setDate(4, java.sql.Date.valueOf(t.getTransaction_date()));
			pstmt.executeUpdate();  
		}  
	}

	@Override
	public List<Transaction> getTransaction(Account a) throws SQLException, IOException{
		List<Transaction> listTransac = new ArrayList<Transaction>();
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM TRANSACTION WHERE ACCOUNT_ID = ? ORDER BY TRANSACTION_ID DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a.getAccount_id()); 
			ResultSet rs = pstmt.executeQuery(); 
			while (rs.next()){
				int id = rs.getInt("TRANSACTION_ID");
				int account_id = rs.getInt("ACCOUNT_ID"); 
				String transaction_type = rs.getString("TRANSACTION_TYPE"); 
				float transaction_amt = rs.getFloat("TRANSACTION_AMT");
				LocalDate transaction_date = rs.getDate("TRANSACTION_DATE").toLocalDate();
				listTransac.add(new Transaction(id, account_id, transaction_type, transaction_amt, transaction_date));
			}  
		} 
		return listTransac;  
	} 
}
package com.revature.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.domain.Transaction;
import com.revature.bank.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao{
	public TransactionDaoImpl(){};
	
	@Override
	public List<Transaction> getTransactions(int acID) {
		PreparedStatement pstmt = null;
		List<Transaction> transList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM TRANSACTIONS WHERE AC_ID=? ORDER BY TRAN_DATE DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,acID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int tranId = rs.getInt("TRAN_ID");
				int acId = rs.getInt("AC_ID");
				Date date = rs.getDate("TRAN_DATE");
				String tranType = rs.getString("ACTION_TYPE");
				double before = rs.getDouble("BEFORE_BAL");
				double after = rs.getDouble("AFTER_BAL");
				transList.add(new Transaction(tranId, acId, date, tranType, before, after));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return transList;

	}
	

}

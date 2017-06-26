package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Util.ConnectionUtil;
import com.revature.domain.Account;
import com.revature.domain.TransLog;
import com.revature.domain.User;

public class TransLogImpl implements TransLogDao{
	AccountImpl ad = new AccountImpl();
	UserImpl ud = new UserImpl();
	public TransLogImpl() {
	}

	@Override
	public List<TransLog> getAllTransactions(int ID) throws InvalidUsernameException, InvalidAccountException {
		ArrayList<TransLog> logs = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM TRANS_LOG WHERE ACCOUNT_OWNER = ? ORDER BY LOG_ID DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Account account = ad.getAccount(rs.getInt("ACCOUNT_ID"));
				double balance = rs.getDouble("AMT_CHANGE");
				User user = ud.getUser(rs.getInt("ACCOUNT_OWNER"));
				TransLog log = new TransLog(rs.getInt("LOG_ID"),account,balance,user);
				logs.add(log);
			} 
			if(logs.isEmpty()) {
				System.out.println("No transactions found");;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return logs;
	}

	@Override
	public TransLog getLog(int ID) throws InvalidAccountException, InvalidUsernameException {
		TransLog log = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM TRAN_LOG WHERE ACCOUNT_OWNER = ? ORDER BY LOG_ID DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Account account = ad.getAccount(rs.getInt("ACCOUNT_ID"));
				double balance = rs.getDouble("AMT_CHANGE");
				User user = ud.getUser(rs.getInt("ACCOUNT_OWNER"));
				log = new TransLog(account,balance,user);
			} else{
				throw new InvalidAccountException();
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return log;
	}


	

}

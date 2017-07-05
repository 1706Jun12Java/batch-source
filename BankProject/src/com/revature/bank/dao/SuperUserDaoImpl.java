package com.revature.bank.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.domain.User;
import com.revature.bank.util.ConnectionUtil;

public class SuperUserDaoImpl extends UserDaoImpl implements SuperUserDao{

	public SuperUserDaoImpl(){};
	
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM BANK_USER ORDER BY USER_ID";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PW");
				int type = rs.getInt("USER_TYPE");
				userList.add(new User(id,username,password,type));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	
	public int updateUser(User user) {
		int updated = 0;
		CallableStatement cs = null;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "{call SP_UPDATE_BANK_USER(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, user.getUserID());
			cs.setString(2, user.getUsername());
			cs.setString(3, user.getPassword());
			cs.setInt(4,user.getUserType());
			updated = cs.executeUpdate();
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return updated;
	}
	
	public int deleteUser(int id) {
		int userDeleted = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			con.setAutoCommit(false); //manual tx management
			String sql = "DELETE FROM BANK_USER WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			userDeleted = pstmt.executeUpdate();
			con.commit();
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return userDeleted;
	}
	
	public User getUserById(int id) {
		PreparedStatement pstmt = null;
		
		User user = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM BANK_USER WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int user_id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int type = rs.getInt("USER_TYPE");
				user = new User(user_id,username,password,type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}

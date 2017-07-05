package com.chase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chase.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	
	public static int getUserByUsername(String username){
		
		Connection con = null;
		int userId = 0;
		
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT USER_ID FROM USER_S WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				userId = rs.getInt("USER_ID");
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return userId;
		
	}
}

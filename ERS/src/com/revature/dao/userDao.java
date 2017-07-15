package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class userDao {

	public userDao() {		
	}
	
	public ResultSet login(String uname, String upassword) {
		
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
						
			ps = con.prepareStatement("SELECT * from ERS_USERS where U_USERNAME =? and U_PASSWORD=?");			
			ps.setString(1, uname);
			ps.setString(2, upassword);			
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rs;		     
	}
}

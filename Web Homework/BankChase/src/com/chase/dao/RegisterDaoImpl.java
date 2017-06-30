package com.chase.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chase.util.ConnectionUtil;

public class RegisterDaoImpl implements RegisterDao {

	
	public static void signUp(String firstname,String lastname,String phoneNum,String email,String username,String password) {
		int usersCreated = 0;
		Connection con = null;
		
		try{
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "INSERT INTO USER_S (USER_TYPE_ID,FIRSTNAME,LASTNAME,PHONE_NUM,EMAIL,USER_NAME,PASS_WORD)"
					+" VALUES(1,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,firstname);
			pstmt.setString(2,lastname);
			pstmt.setString(3,phoneNum);
			pstmt.setString(4,email);
			pstmt.setString(5,username);
			pstmt.setString(6,password);
			usersCreated = pstmt.executeUpdate();
			if (usersCreated > 0){
				System.out.println("Registration complete");
			}
			else{
				System.out.println("Failed to register");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

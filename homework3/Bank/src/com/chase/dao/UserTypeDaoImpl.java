package com.chase.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chase.domain.UserType;
import com.chase.util.ConnectionUtil;

public class UserTypeDaoImpl implements UserTypeDao{

	@Override
	public UserType getUserTypeById(int utid) {

		PreparedStatement pstmt = null;
		UserType ut = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM USER_TYPE WHERE USER_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,utid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String access = rs.getString("USER_TYPE_ACCESS");
				ut = new UserType(utid,access);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return ut;
	}
}




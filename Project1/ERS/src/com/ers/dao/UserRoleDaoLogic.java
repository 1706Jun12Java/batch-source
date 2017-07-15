package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.util.ConnectionUtil;

public class UserRoleDaoLogic implements UserRoleDao {

	@Override
	public int getIdOfRole(String role) {
		int roleId = 0;
		String sql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = ?";

		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, role);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				roleId = rs.getInt("UR_ID");
			} else {
				System.out.println("Something went wrong. Please try again.");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return roleId;
	}

}

package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.UserType;
import com.revature.util.ConnectionUtil;

public class ERUserTypeDaoImpl implements ERUserTypeDao{

	public ERUserTypeDaoImpl(){}
	
	@Override
	public List<UserType> getUserTypes() {
		
		List<UserType> typeList= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_USER_ROLE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("UR_ID");
				String role = rs.getString("UR_ROLE");
				UserType newUT = new UserType(id,role);
				typeList.add(newUT);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return typeList;
	}

	@Override
	public UserType getUserTypeById(int id) {
		
		PreparedStatement pstmt = null;
		UserType userType = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_USER_ROLE WHERE UR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int urId = rs.getInt("UR_ID");
				String type = rs.getString("UR_ROLE");
				userType = new UserType(urId, type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return userType;
	}
	
}

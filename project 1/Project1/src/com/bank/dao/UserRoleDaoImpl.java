package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.domain.UserRole;
import com.bank.util.ConnectionUtil;

public class UserRoleDaoImpl implements UserRoleDao{

	
	public static UserRole geUserRoleById(int id){
		
		UserRole ur = new UserRole();
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE UR_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int ur_id = rs.getInt("UR_ID");
				String role = rs.getString("UR_ROLE");
				UserRole ur2 = new UserRole(ur_id,role);
				ur = ur2;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return ur;
	}
}

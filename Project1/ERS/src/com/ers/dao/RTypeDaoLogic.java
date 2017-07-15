package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.util.ConnectionUtil;

public class RTypeDaoLogic implements RTypeDao {

	@Override
	public int getIdOfType(String type) {
		int typeId = 0;
		String sql = "SELECT RT_ID FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = ?";

		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, type);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				typeId = rs.getInt("RT_ID");
			} else {
				System.out.println("Something went wrong. Please try again.");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return typeId;
	}

}

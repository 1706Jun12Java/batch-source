package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.util.ConnectionUtil;

public class RStatusDaoLogic implements RStatusDao {

	@Override
	public int getIdOfStatus(String status) {
		int statusId = 0;
		String sql = "SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = ?";

		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, status);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				statusId = rs.getInt("RS_ID");
			} else {
				System.out.println("Something went wrong. Please try again.");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return statusId;
	}
}

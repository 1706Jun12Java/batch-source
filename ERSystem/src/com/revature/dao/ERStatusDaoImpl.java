package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.ReStatus;

import com.revature.util.ConnectionUtil;

public class ERStatusDaoImpl implements ERStatusDao{

	public ERStatusDaoImpl() {
	}

	@Override
	public List<ReStatus> getReStatusList() {
		
		List<ReStatus> rsList= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("RS_ID");
				String status = rs.getString("RS_STATUS");
				ReStatus newRS = new ReStatus(id,status);
				rsList.add(newRS);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return rsList;
	}

	@Override
	public ReStatus getStatusById(int id) {
		PreparedStatement pstmt = null;
		ReStatus status = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String type = rs.getString("RS_STATUS");
				status = new ReStatus(id, type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return status;
	
	}
}

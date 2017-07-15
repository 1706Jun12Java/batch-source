package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.ReType;
import com.revature.util.ConnectionUtil;

public class ERTypeDaoImpl implements ERTypeDao{
	
	public ERTypeDaoImpl(){};

	@Override
	public List<ReType> getReTypes() {
		List<ReType> rt= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("RT_ID");
				String type = rs.getString("RT_TYPE");
				ReType newRT = new ReType(id,type);
				rt.add(newRT);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return rt;
	}

	@Override
	public ReType getReTypeById(int id) {
		
		PreparedStatement pstmt = null;
		ReType rt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE RT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String type = rs.getString("RT_TYPE");
				rt = new ReType(id, type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return rt;
	}

}

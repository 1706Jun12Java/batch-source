package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.domain.ReimbursementStatus;
import com.bank.util.ConnectionUtil;

public class ReimbursementStatusDaoImpl implements ReimbursementStatusDao {

	
	public static ReimbursementStatus getReimbursementStatusById(int id){
		 Connection con = null;
		 ReimbursementStatus status = new ReimbursementStatus();
		 
		 try{
			 con = ConnectionUtil.getConnectionFromFile();
			 String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID = ?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 int rt_id = rs.getInt("RS_ID");
				 String rt_type = rs.getString("RS_STATUS");
				 ReimbursementStatus status2 = new ReimbursementStatus(rt_id,rt_type);
				 status = status2;
				 }
		 }
		 catch (Exception e){
			 e.printStackTrace();
		 }
		 return status;
	}
}

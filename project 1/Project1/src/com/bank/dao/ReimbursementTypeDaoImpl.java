package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.domain.ReimbursementType;
import com.bank.util.ConnectionUtil;

public class ReimbursementTypeDaoImpl implements ReimbursementTypeDao {

	public static ReimbursementType getReimbursementTypeById(int id){
		 Connection con = null;
		 ReimbursementType type = new ReimbursementType();
		 
		 try{
			 con = ConnectionUtil.getConnectionFromFile();
			 String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE RT_ID = ?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 int rt_id = rs.getInt("RT_ID");
				 String rt_type = rs.getString("RT_TYPE");
				 ReimbursementType type2 = new ReimbursementType(rt_id,rt_type);
				 type = type2;
				 } 
		 }
		 catch (Exception e){
			 e.printStackTrace();
		 }
		 return type;
	}
}

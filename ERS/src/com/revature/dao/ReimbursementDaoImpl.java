package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl {

	public ReimbursementDaoImpl() {
		
	}		
		
	public List<Reimbursement> allReimbursements() {
		
		List<Reimbursement> rl = new ArrayList<>();		
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = null;
			ResultSet rs = null; 			
			ps = con.prepareStatement("SELECT R.R_ID,R.R_AMOUNT,R.R_DESCRIPTION,R.R_SUBMITTED,R.R_RESOLVED,U.U_FIRSTNAME||' '||U.U_LASTNAME AS AUTHOR,U2.U_FIRSTNAME||' '||U2.U_LASTNAME AS RESOLVER,RS.RS_STATUS AS STATUS, RT.RT_TYPE AS TYPE FROM ERS_REIMBURSEMENTS R LEFT JOIN ERS_USERS U ON R.U_ID_AUTHOR = U.U_ID LEFT JOIN ERS_USERS U2 ON R.U_ID_RESOLVER = U2.U_ID LEFT JOIN ERS_REIMBURSEMENT_STATUS RS ON R.RS_STATUS = RS.RS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE RT ON R.RT_TYPE = RT.RT_ID");		
			rs = ps.executeQuery();
			while(rs.next()){
				int rid = rs.getInt("R_ID");
				String rstatus = rs.getString("STATUS");
				int ramount = rs.getInt("R_AMOUNT");				               
				String rdescr = rs.getString("R_DESCRIPTION");
				Timestamp rsubmitted = rs.getTimestamp("R_SUBMITTED");
				String rauthor = rs.getString("AUTHOR");
				String rtyp = rs.getString("TYPE");
				Timestamp rresolved = rs.getTimestamp("R_RESOLVED");
				String rresolver = rs.getString("RESOLVER");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rl;		     
	}
	
}

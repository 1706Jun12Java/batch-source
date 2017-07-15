package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.Exceptions.InvalidReimburstmentException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Util.ConnectionUtil;
import com.revature.domain.Reimburstment;

public class ReimburstmentImpl implements ReimburstmentDao {
	
	public ReimburstmentImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendReimburstmet(int userID, Double amount, String description, String pic, String type) throws InvalidReimburstmentException ,SQLException{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql;
				PreparedStatement ps;
				sql = "INSERT INTO REIMBURSMENT (AMOUNT,R_DESCRIBE,TIME_SUBMITTED,TIME_RESOLVED,USER_SUBMITTER,USER_RESOLVER,R_TYPE,R_STATUS,R_PICTURE) VALUES (?,?,DEFAULT,NULL,?,DEFAULT,?,DEFAULT,?)";
				ps = con.prepareStatement(sql);
				ps.setDouble(1, amount);
				ps.setString(2, description);
				ps.setString(5,pic);
				ps.setInt(3,userID);
				ps.setString(4, type);
				ps.executeUpdate();			
	}

	@Override
	public List<Reimburstment> getReimburstmentByUser(int userID) throws InvalidReimburstmentException, InvalidUsernameException,SQLException {
			List<Reimburstment> r = new ArrayList<Reimburstment>();
			E_UserImpl eui = new E_UserImpl();
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql;
			PreparedStatement ps;
			sql = "SELECT * FROM REIMBURSMENT WHERE USER_SUBMITTER = ?";
			ps = con.prepareStatement(sql);
			if(userID != 0)
			ps.setInt(1,userID);
			else{
				ps.setNull(1, Types.INTEGER);
			}
			ResultSet rs = ps.executeQuery();
			try{
			while(rs.next()){
				int id = rs.getInt("R_ID");
				Double amount = rs.getDouble("AMOUNT");
				String description = rs.getString("R_DESCRIBE");
				String picture = rs.getString("R_PICTURE");
				Timestamp recievedTime = rs.getTimestamp("TIME_SUBMITTED");
				Timestamp handledTime = rs.getTimestamp("TIME_RESOLVED");
				int uID = rs.getInt("USER_SUBMITTER");
				int managerID = rs.getInt("USER_RESOLVER");
				String type = rs.getString("R_TYPE");
				String status = rs.getString("R_STATUS");
				Reimburstment rei = new Reimburstment(id,amount,description,picture,eui.getUser(uID),eui.getUser(managerID),recievedTime,handledTime,type,status);	
				r.add(rei);
			}
			if(r.isEmpty()){
				throw new InvalidUsernameException("Currently no reimburstments.");
			}
			}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}
			return r;
	}

	@Override
	public List<Reimburstment> getAllReimburstments() throws InvalidReimburstmentException,SQLException, InvalidUsernameException {
		ArrayList<Reimburstment> r = new ArrayList<Reimburstment>();
		E_UserImpl eui = new E_UserImpl();
		Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
		String sql;
		PreparedStatement ps;
		sql = "SELECT * FROM REIMBURSMENT";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		try{
		while(rs.next()){
			int id = rs.getInt("R_ID");
			Double amount = rs.getDouble("AMOUNT");
			String description = rs.getString("R_DESCRIBE");
			String picture = rs.getString("R_PICTURE");
			Timestamp recievedTime = rs.getTimestamp("TIME_SUBMITTED");
			Timestamp handledTime = rs.getTimestamp("TIME_RESOLVED");
			int userID = rs.getInt("USER_SUBMITTER");
			int managerID = rs.getInt("USER_RESOLVER");
			String type = rs.getString("R_TYPE");
			String status = rs.getString("R_STATUS");
			Reimburstment rei = new Reimburstment(id,amount,description,picture,eui.getUser(userID),eui.getUser(managerID),recievedTime,handledTime,type,status);
			r.add(rei);
		}
		}finally{
			try { rs.close(); } catch (Exception ignore) { }
		}
		return r;
	}

	@Override
	public void updateReimburstment(int reimburstmentID, String approval,int managerID)
			throws InvalidReimburstmentException, SQLException {
		Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
		String sql;
			PreparedStatement ps;
			sql = "UPDATE REIMBURSMENT SET USER_RESOLVER = ?,R_STATUS = ?, TIME_RESOLVED = DEFAULT WHERE R_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(3, reimburstmentID);
			ps.setString(2, approval);
			ps.setInt(1,managerID);
			ps.executeUpdate();
	}

	@Override
	public void deleteReimburstment(int reimburstmentID) throws InvalidReimburstmentException, SQLException {
		Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
		String sql;
			PreparedStatement ps;
			sql = "DELETE FROM REIMBURSMENT WHERE R_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, reimburstmentID);
			ps.executeUpdate();

	}

}

package com.revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public ReimbursementDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ReimbursementTicket> getReimbursementTickets() {
		PreparedStatement pstmt = null;
		List<ReimbursementTicket> rts = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Blob receipt= rs.getBlob("R_RECEIPT");
				Timestamp submitted= rs.getTimestamp("SUBMITTED");
				Timestamp resolved= rs.getTimestamp("RESOLVED");
				int submitterId = rs.getInt("U_ID_AUTHOR");
				int resolverId = rs.getInt("U_ID_RESOLVER");
				int rType = rs.getInt("R_TYPE");
				int rStatus = rs.getInt("R_STATUS");
				rts.add(new ReimbursementTicket(rId,amount,description,receipt,submitted,resolved,submitterId,resolverId,rType,rStatus));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rts;
	}

	@Override
	public List<ReimbursementTicket> getReimbursementTicketsByEmp(User emp) {
		PreparedStatement pstmt = null;
		List<ReimbursementTicket> rts = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getU_id());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Blob receipt= rs.getBlob("R_RECEIPT");
				Timestamp submitted= rs.getTimestamp("SUBMITTED");
				Timestamp resolved= rs.getTimestamp("RESOLVED");
				int submitterId = rs.getInt("U_ID_AUTHOR");
				int resolverId = rs.getInt("U_ID_RESOLVER");
				int rType = rs.getInt("R_TYPE");
				int rStatus = rs.getInt("R_STATUS");
				rts.add(new ReimbursementTicket(rId,amount,description,receipt,submitted,resolved,submitterId,resolverId,rType,rStatus));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rts;
	}

	@Override
	public String getReimbursementTicketStatus(ReimbursementTicket rt) {
		PreparedStatement pstmt = null;
		String status="";
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_R_STATUS WHERE RS_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rt.getR_status());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				status=rs.getString("RS_STATUS");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	@Override
	public String getReimbursementTicketType(ReimbursementTicket rt) {
		PreparedStatement pstmt = null;
		String status="";
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_R_TYPE WHERE RT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rt.getR_type());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				status=rs.getString("RT_TYPE");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	@Override
	public ReimbursementTicket getReimbursementTicketById(int id) {
		PreparedStatement pstmt = null;
		ReimbursementTicket rt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE R_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Blob receipt= rs.getBlob("R_RECEIPT");
				Timestamp submitted= rs.getTimestamp("SUBMITTED");
				Timestamp resolved= rs.getTimestamp("RESOLVED");
				int submitterId = rs.getInt("U_ID_AUTHOR");
				int resolverId = rs.getInt("U_ID_RESOLVER");
				int rType = rs.getInt("R_TYPE");
				int rStatus = rs.getInt("R_STATUS");
				rt = (new ReimbursementTicket(rId,amount,description,receipt,submitted,resolved,submitterId,resolverId,rType,rStatus));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rt;
	}

	@Override
	public List<ReimbursementTicket> getPendingReimbursementTickets() {
		PreparedStatement pstmt = null;
		List<ReimbursementTicket> rts = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE R_STATUS = 1";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Blob receipt= rs.getBlob("R_RECEIPT");
				Timestamp submitted= rs.getTimestamp("SUBMITTED");
				Timestamp resolved= rs.getTimestamp("RESOLVED");
				int submitterId = rs.getInt("U_ID_AUTHOR");
				int resolverId = rs.getInt("U_ID_RESOLVER");
				int rType = rs.getInt("R_TYPE");
				int rStatus = rs.getInt("R_STATUS");
				rts.add(new ReimbursementTicket(rId,amount,description,receipt,submitted,resolved,submitterId,resolverId,rType,rStatus));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rts;
		
	}
	
	@Override
	public List<ReimbursementTicket> getResolvedReimbursementTickets() {
		PreparedStatement pstmt = null;
		List<ReimbursementTicket> rts = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE R_STATUS = 2 OR R_STATUS = 3";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Blob receipt= rs.getBlob("R_RECEIPT");
				Timestamp submitted= rs.getTimestamp("SUBMITTED");
				Timestamp resolved= rs.getTimestamp("RESOLVED");
				int submitterId = rs.getInt("U_ID_AUTHOR");
				int resolverId = rs.getInt("U_ID_RESOLVER");
				int rType = rs.getInt("R_TYPE");
				int rStatus = rs.getInt("R_STATUS");
				rts.add(new ReimbursementTicket(rId,amount,description,receipt,submitted,resolved,submitterId,resolverId,rType,rStatus));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rts;
	}
	
	@Override
	public boolean registerNewTicket(ReimbursementTicket rt, InputStream is) {
		PreparedStatement pstmt = null;
		int rtCreated = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT,R_DESCRIPTION,R_RECEIPT,SUBMITTED,U_ID_AUTHOR,R_TYPE,R_STATUS) "
					+ "VALUES (?,?,?,?,?,?,?)";
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			Timestamp ts=new Timestamp(now.getTime());
			System.out.println(ts);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, rt.getR_amount());
			pstmt.setString(2, rt.getR_description());
			pstmt.setBlob(3, is);
			pstmt.setTimestamp(4, ts);
			pstmt.setInt(5, rt.getU_id_author());
			pstmt.setInt(6, rt.getR_type());
			pstmt.setInt(7, rt.getR_status());

			rtCreated = pstmt.executeUpdate();
			
			if(rtCreated == 1){
				con.commit();
				con.setAutoCommit(true);
				return true;
			} 
			else {
				con.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveTicket(ReimbursementTicket rt, User user) {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "UPDATE ERS_REIMBURSEMENTS SET R_STATUS = 2, RESOLVED=? , U_ID_RESOLVER=? WHERE R_ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			Timestamp ts=new Timestamp(now.getTime());
			
			pstmt.setTimestamp(1, ts);
			pstmt.setInt(2, user.getU_id());
			pstmt.setInt(3, rt.getR_id());
			if(pstmt.executeUpdate() == 1){
				con.commit();
				con.setAutoCommit(true);
				return true;
			} 
			else {
				con.rollback();
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyTicket(ReimbursementTicket rt, User user) {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "UPDATE ERS_REIMBURSEMENTS SET R_STATUS = 3, RESOLVED=? , U_ID_RESOLVER=? WHERE R_ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			Timestamp ts=new Timestamp(now.getTime());
			
			pstmt.setTimestamp(1, ts);
			pstmt.setInt(2, user.getU_id());
			pstmt.setInt(3, rt.getR_id());
			if(pstmt.executeUpdate() == 1){
				con.commit();
				con.setAutoCommit(true);
				return true;
			} 
			else {
				con.rollback();
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Blob getBlobById(int id) {
		PreparedStatement pstmt = null;
		Blob receipt=null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT R_RECEIPT FROM ERS_REIMBURSEMENTS WHERE R_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				receipt= rs.getBlob("R_RECEIPT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return receipt;
	}

}

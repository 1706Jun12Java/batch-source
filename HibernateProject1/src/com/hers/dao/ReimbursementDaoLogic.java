package com.hers.dao;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ers.util.ConnectionUtil;
import com.hers.domain.ReimbursementModel;
import com.hers.domain.UserModel;
import com.hers.util.HibernateUtil;

public class ReimbursementDaoLogic implements ReimbursementDao {

	@Override
	public List<ReimbursementModel> getEmployeeAllReimbursementRequests(int employeeId, int rStatusId) {
		Session s = HibernateUtil.getSession();
		List<ReimbursementModel> reimbursements = new ArrayList<ReimbursementModel>();
		reimbursements = s.createQuery("from ReimbursementModel where id=:employeeId and statusId=:rStatusId")
							.setInteger("employeeId", employeeId).setInteger("rStatusId", rStatusId).list();
		
		return reimbursements;
		
//		List<ReimbursementModel> reimbursements = new ArrayList<>();
//		String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ? AND RT_STATUS = ?";
//		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
//				PreparedStatement pstmt = con.prepareStatement(sql)){
//			pstmt.setInt(1, employeeId);
//			pstmt.setInt(2, rStatusId);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int id = rs.getInt("R_ID");
//				BigDecimal amount = rs.getBigDecimal("R_AMOUNT");
//				String description = rs.getString("R_DESCRIPTION");
//				Blob receipt = rs.getBlob("R_RECEIPT");
//				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
//				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
//				int authorId = rs.getInt("U_ID_AUTHOR");
//				int resolverId = rs.getInt("U_ID_RESOLVER");
//				int type = rs.getInt("RT_TYPE");
//				int status = rs.getInt("RT_STATUS");
//				
//				reimbursements.add(new ReimbursementModel(id, amount, description, receipt, submitted, resolved, authorId, resolverId, type, status));
//			}
//		} catch (SQLException e){
//			e.printStackTrace();
//		} catch (IOException e){
//			e.printStackTrace();
//		}
//		return reimbursements;
	}

	@Override
	public void submitReimbursementRequest(BigDecimal rAmount, String rDescription, InputStream rReceipt,
			Timestamp rSubmitted, int uIdAuthor, int rtType) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			ReimbursementModel rm = new ReimbursementModel();
			rm.setAmount(rAmount);
			rm.setDescription(rDescription);
			rm.setReceipt(rReceipt);
			rm.setSubmitted(rSubmitted);
			rm.setAuthorId(uIdAuthor);
			rm.setType(rtType);
		
		tx.commit();
		s.close();
		
		
		
		
	}
//		int submitSuccess=0;
//		String sql = "INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED, "
//				+ "U_ID_AUTHOR, RT_TYPE) VALUES(?,?,?,?,?,?)";
//		
//		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
//			PreparedStatement pstmt = con.prepareStatement(sql)){
//			
//			con.setAutoCommit(false);
//			pstmt.setBigDecimal(1, rAmount);
//			pstmt.setString(2, rDescription);
//			pstmt.setBlob(3, rReceipt);
//			pstmt.setTimestamp(4, rSubmitted);
//			pstmt.setInt(5, uIdAuthor);
//			pstmt.setInt(6, rtType);
//			
//			submitSuccess = pstmt.executeUpdate();
//			con.commit();
//		} catch (SQLException e){
//			e.printStackTrace();
//		} catch (IOException e){
//			e.printStackTrace();
//		}
//		return submitSuccess==1;
//		
//	}

	@Override
	public List<ReimbursementModel> getAllEmployeesReimbursementRequests(int managerId, int rStatusId) {
		List<ReimbursementModel> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = ?";

		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, rStatusId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("R_ID");
				BigDecimal amount = rs.getBigDecimal("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Blob receipt = rs.getBlob("R_RECEIPT");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int authorId = rs.getInt("U_ID_AUTHOR");
				int resolverId = rs.getInt("U_ID_RESOLVER");
				int type = rs.getInt("RT_TYPE");
				int status = rs.getInt("RT_STATUS");
				
				reimbursements.add(new ReimbursementModel(id, amount, description, receipt, submitted, resolved, authorId, resolverId, type, status));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return reimbursements;
		
			
		

		
		
	}

	@Override
	public boolean approveOrDenyReimbursementRequest(int reimbursementId, Timestamp resolved, int resolverId, int statusId) {
		int rStatusResolved = 0;
		String sql = "UPDATE ERS_REIMBURSEMENTS " +
				"SET R_RESOLVED = ?, U_ID_RESOLVER = ?, RT_STATUS = ?" +
				"WHERE R_ID = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			con.setAutoCommit(false);
			pstmt.setTimestamp(1, resolved);
			pstmt.setInt(2, resolverId);
			pstmt.setInt(3, statusId);
			
			rStatusResolved = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return rStatusResolved==1;
	}

}

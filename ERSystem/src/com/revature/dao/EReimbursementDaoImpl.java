package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.util.ConnectionUtil;

public class EReimbursementDaoImpl implements EReimbursementDao{

	public EReimbursementDaoImpl() {}

	@Override
	public List<Reimbursement> getReimbursements() {
		PreparedStatement pstmt = null;
		List<Reimbursement> reimList= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT R_ID, R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED, RS_STATUS, C.RT_TYPE FROM ERS_REIMBURSEMENT A LEFT JOIN ERS_REIMBURSEMENT_STATUS B ON (A.RT_STATUS = B.RS_ID) LEFT JOIN ERS_REIMBURSEMENT_TYPE C ON (A.RT_TYPE = C.RT_ID) ORDER BY A.R_SUBMITTED DESC";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Date submitted = rs.getDate("R_SUBMITTED");
				Date resolved = rs.getDate("R_RESOLVED");
				String statusName = rs.getString("RS_STATUS");
				String typeName = rs.getString("RT_TYPE");
				Reimbursement reim = new Reimbursement(id,amount,description,submitted,resolved,typeName,statusName);
				reimList.add(reim);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return reimList;
	}

	@Override
	public List<Reimbursement> getReimbursementsByUser(int userId) {
		
		PreparedStatement pstmt = null;
		List<Reimbursement> reimList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT R_ID, R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED, RS_STATUS, C.RT_TYPE FROM ERS_REIMBURSEMENT A LEFT JOIN ERS_REIMBURSEMENT_STATUS B ON (A.RT_STATUS = B.RS_ID) LEFT JOIN ERS_REIMBURSEMENT_TYPE C ON (A.RT_TYPE = C.RT_ID) WHERE U_ID_AUTHOR = ? ORDER BY A.R_SUBMITTED DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Date submitted = rs.getDate("R_SUBMITTED");
				Date resolved = rs.getDate("R_RESOLVED");
				String statusName = rs.getString("RS_STATUS");
				String typeName = rs.getString("RT_TYPE");
				Reimbursement reim = new Reimbursement(id,amount,description,submitted,resolved,typeName,statusName);
				reimList.add(reim);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	@Override
	public int approveReimbursement(int id) {
		
		int approved = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			con = ConnectionUtil.getConnectionFromFile();

			String sql = "UPDATE ERS_REIMBURSEMENT SET R_RESOLVED=?, RT_STATUS=? WHERE R_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setInt(2, 3);
			pstmt.setInt(3, id);
			approved = pstmt.executeUpdate();
			if(approved==1){
				System.out.println("approved");
			}else{
				System.out.println("could not approve");
			}
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return approved;
	}

	@Override
	public int denyReimbursement(int id) {
		
		int deny = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			
			String sql = "UPDATE ERS_REIMBURSEMENT SET R_RESOLVED=?, RT_STATUS=? WHERE R_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setInt(2, 2);
			pstmt.setInt(3, id);
			deny = pstmt.executeUpdate();
			if(deny==1){
				System.out.println("DENIED");
			}else{
				System.out.println("could not deny");
			}
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return deny;
	}

	@Override
	public int addReimbursement(Reimbursement r) {
		
		int add = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "INSERT INTO ERS_REIMBURSEMENT "
					+ "(R_AMOUNT,R_DESCRIPTION,R_RECEIPE,U_ID_AUTHOR,RT_TYPE)"
					+ "VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, r.getAmount());
			pstmt.setString(2, r.getDescription());
			pstmt.setBinaryStream(3,r.getReceipe(),r.getReceipe().available()); 
			pstmt.setInt(4, r.getAuthor());
			pstmt.setInt(5, r.getType());
			add = pstmt.executeUpdate();
			if(add==1){
				System.out.println("added");
			}else{
				System.out.println("could not add");
			}
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return add;
	}

	@Override
	public int updateReStatus(int reId, int resolver, int status) {
		int update = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE ERS_REIMBURSEMENT SET U_ID_RESOLVER=?,RT_STATUS=?,R_RESOLVED=? WHERE R_ID=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, resolver);
			pstmt.setInt(2, status);
			pstmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setInt(4, reId);
			update = pstmt.executeUpdate();
			if(update==1){
				System.out.println("UPDATED");
			}else{
				System.out.println("could not update");
			}
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public Blob getImageById(int id) {
		Blob img = null;
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT R_RECEIPE FROM ERS_REIMBURSEMENT WHERE R_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				img = rs.getBlob("R_RECEIPE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public Reimbursement getReimbursementById(int tid) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT R_ID, R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED, RS_STATUS, C.RT_TYPE, D.U_FIRSTNAME||-||D.U_LASTNAME AS FULLNAME FROM ERS_REIMBURSEMENT A LEFT JOIN ERS_REIMBURSEMENT_STATUS B ON (A.RT_STATUS = B.RS_ID) LEFT JOIN ERS_REIMBURSEMENT_TYPE C ON (A.RT_TYPE = C.RT_ID) LEFT JOIN ERS_USER ON (A.U_ID_RESOLVER=D.U_ID) WHERE A.R_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,tid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Date submitted = rs.getDate("R_SUBMITTED");
				Date resolved = rs.getDate("R_RESOLVED");
				String resolver = rs.getString("FULLNAME");
				String statusName = rs.getString("RS_STATUS");
				String typeName = rs.getString("RT_TYPE");
				return new Reimbursement(id,amount,description,submitted,resolved,typeName,statusName,resolver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.bank.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bank.domain.Reimbursement;
import com.bank.domain.ReimbursementStatus;
import com.bank.domain.ReimbursementType;
import com.bank.domain.User;
import com.bank.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public ReimbursementDaoImpl() {

	}

	public static void reimburseRequest(double amount, String description, int uid, int type) {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();

			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT,R_DESCRIPTION,R_SUBMITTED,U_ID_AUTHOR,RT_TYPE,RT_STATUS)"
							+ "VALUES (?,?,?,?,?,3)");
			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setDate(3, date);
			ps.setInt(4, uid);
			ps.setInt(5, type);

			ps.executeQuery();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static List<Reimbursement> viewPendingReimbursements(int id) {

		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int r_id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int type2 = rs.getInt("RT_TYPE");
				ReimbursementType type = ReimbursementTypeDaoImpl.getReimbursementTypeById(type2);
				int status2 = rs.getInt("RT_STATUS");
				ReimbursementStatus status = ReimbursementStatusDaoImpl.getReimbursementStatusById(status2);
				if (resolved == null) {
					Reimbursement reim2 = new Reimbursement(r_id, amount, description, submitted, resolved, type,
							status);
					reim.add(reim2);
				}
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reim;
	}

	public static List<Reimbursement> viewResolvedReimbursements(int id) {

		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int r_id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int type2 = rs.getInt("RT_TYPE");
				ReimbursementType type = ReimbursementTypeDaoImpl.getReimbursementTypeById(type2);
				int status2 = rs.getInt("RT_STATUS");
				ReimbursementStatus status = ReimbursementStatusDaoImpl.getReimbursementStatusById(status2);
				if (resolved != null) {
					Reimbursement reim2 = new Reimbursement(r_id, amount, description, submitted, resolved, type,
							status);
					reim.add(reim2);
				}

			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reim;
	}

	public static List<Reimbursement> viewAllPendingReimbursements() {

		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int r_id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int u_id = rs.getInt("U_ID_AUTHOR");
				User user = UserDaoImpl.getUserById(u_id);
				int type2 = rs.getInt("RT_TYPE");
				ReimbursementType type = ReimbursementTypeDaoImpl.getReimbursementTypeById(type2);
				int status2 = rs.getInt("RT_STATUS");
				ReimbursementStatus status = ReimbursementStatusDaoImpl.getReimbursementStatusById(status2);
				if (resolved == null) {
					Reimbursement reim2 = new Reimbursement(r_id, amount, description, submitted, resolved, user, type,
							status);
					reim.add(reim2);
				}

			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reim;
	}

	public static List<Reimbursement> viewAllResolvedReimbursements() {

		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int r_id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int u_id = rs.getInt("U_ID_AUTHOR");
				User user = UserDaoImpl.getUserById(u_id);
				int uu_id = rs.getInt("U_ID_RESOLVER");
				User manager = UserDaoImpl.getUserById(uu_id);
				int type2 = rs.getInt("RT_TYPE");
				ReimbursementType type = ReimbursementTypeDaoImpl.getReimbursementTypeById(type2);
				int status2 = rs.getInt("RT_STATUS");
				ReimbursementStatus status = ReimbursementStatusDaoImpl.getReimbursementStatusById(status2);
				if (resolved != null) {
					Reimbursement reim2 = new Reimbursement(r_id, amount, description, submitted, resolved, user,
							manager, type, status);
					reim.add(reim2);
				}

			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reim;
	}

	public static void updateStatus(int r_id, int u_id, int status) {

		Connection con = null;
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_REIMBURSEMENTS SET R_RESOLVED = ?,U_ID_RESOLVER = ?, RT_STATUS = ? WHERE R_ID = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, date);
			ps.setInt(2, u_id);
			ps.setInt(3, status);
			ps.setInt(4, r_id);
			ps.execute();
		} catch (Exception e) {

		}
	}

	public static List<Reimbursement> getReimbursementByUsername(int id) {
		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int r_id = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int u_id = rs.getInt("U_ID_AUTHOR");
				User user = UserDaoImpl.getUserById(u_id);
				int uu_id = rs.getInt("U_ID_RESOLVER");
				User manager = UserDaoImpl.getUserById(uu_id);
				int type2 = rs.getInt("RT_TYPE");
				ReimbursementType type = ReimbursementTypeDaoImpl.getReimbursementTypeById(type2);
				int status2 = rs.getInt("RT_STATUS");
				ReimbursementStatus status = ReimbursementStatusDaoImpl.getReimbursementStatusById(status2);
				Reimbursement reim2 = new Reimbursement(r_id, amount, description, submitted, resolved, user, manager,
						type, status);
				reim.add(reim2);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reim;
	}

	public static void submitReceipt(InputStream image, int id, int r_id) {

		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_REIMBURSEMENTS SET R_RECEIPT = ? WHERE U_ID_AUTHOR = ? AND R_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBlob(1, image);
			ps.setInt(2, id);
			ps.setInt(3, r_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readPicture(int materialId, String filename) {
		FileOutputStream fos = null;
		Connection con = null;

		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT R_RECEIPT FROM ERS_REIMBURSEMENTS WHERE r_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, materialId);
			ResultSet rs = ps.executeQuery();

			// write binary stream into file
			File file = new File(filename);
			fos = new FileOutputStream(file);

			System.out.println("Writing BLOB to file " + file.getAbsolutePath());
			while (rs.next()) {
				InputStream input = rs.getBinaryStream("R_RECIPT");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					fos.write(buffer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

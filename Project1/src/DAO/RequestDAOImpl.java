package DAO;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Domain.RRequest;
import Util.ConnectionUtil;

public class RequestDAOImpl implements RequestDAO {

	@Override
	public void push(RRequest req) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ER_REIMBURSTMENTS (R_AMOUNT, R_DESC, R_RECEIPT, R_SUBMITTED, R_RESOLVED, R_AUTHOR, R_RESOLVER, R_TYPE, R_STATUS) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setDouble(1, req.getAmount());
			pdsmt.setString(2, req.getDesc());
			pdsmt.setBinaryStream(3, req.getImage());
			pdsmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			pdsmt.setDate(5, null);
			pdsmt.setString(6, req.getAuthor());
			pdsmt.setString(7, null);
			pdsmt.setString(8, req.getType());
			pdsmt.setString(9, "pending");
			pdsmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<RRequest> getRequests() throws SQLRecoverableException {
		List<RRequest> reqList = new ArrayList<RRequest>();
		RRequest temp = null;
		InputStream in = null;
		Blob b = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ER_REIMBURSTMENTS ORDER BY R_SUBMITTED DESC";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			ResultSet rs = pdsmt.executeQuery();
			while (rs.next()) {
				if (rs.getBlob("R_RECEIPT") != null) {
					b = rs.getBlob("R_RECEIPT");
					in = b.getBinaryStream();
					temp = new RRequest(rs.getInt("R_ID"), rs.getFloat("R_AMOUNT"), rs.getString("R_DESC"),
							rs.getDate("R_SUBMITTED"), rs.getDate("R_RESOLVED"), rs.getString("R_AUTHOR"),
							rs.getString("R_RESOLVER"), rs.getString("R_TYPE"), rs.getString("R_STATUS"), in);
					reqList.add(temp);
				} else {
					temp = new RRequest(rs.getInt("R_ID"), rs.getFloat("R_AMOUNT"), rs.getString("R_DESC"),
							rs.getDate("R_SUBMITTED"), rs.getDate("R_RESOLVED"), rs.getString("R_AUTHOR"),
							rs.getString("R_RESOLVER"), rs.getString("R_TYPE"), rs.getString("R_STATUS"));
					reqList.add(temp);
				}

			}
		} catch (SQLRecoverableException e) {
			throw new SQLRecoverableException();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return reqList;
	}

	@Override
	public List<RRequest> getRequests(String username) throws SQLRecoverableException {
		List<RRequest> reqList = new ArrayList<RRequest>();
		RRequest temp = null;
		InputStream in = null;
		Blob b = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ER_REIMBURSTMENTS WHERE R_AUTHOR = ? ORDER BY R_SUBMITTED DESC";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, username);
			ResultSet rs = pdsmt.executeQuery();
			while (rs.next()) {
				if (rs.getBlob("R_RECEIPT") != null) {
					b = rs.getBlob("R_RECEIPT");
					in = b.getBinaryStream();
					temp = new RRequest(rs.getInt("R_ID"), rs.getFloat("R_AMOUNT"), rs.getString("R_DESC"),
							rs.getDate("R_SUBMITTED"), rs.getDate("R_RESOLVED"), rs.getString("R_AUTHOR"),
							rs.getString("R_RESOLVER"), rs.getString("R_TYPE"), rs.getString("R_STATUS"), in);
					reqList.add(temp);
				} else {
					temp = new RRequest(rs.getInt("R_ID"), rs.getFloat("R_AMOUNT"), rs.getString("R_DESC"),
							rs.getDate("R_SUBMITTED"), rs.getDate("R_RESOLVED"), rs.getString("R_AUTHOR"),
							rs.getString("R_RESOLVER"), rs.getString("R_TYPE"), rs.getString("R_STATUS"));
					reqList.add(temp);
				}

			}
		} catch (SQLRecoverableException e) {
			throw new SQLRecoverableException();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return reqList;
	}

	public void approve(int reqID, String username) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE ER_REIMBURSTMENTS SET R_STATUS = 'approved', R_RESOLVER= ?, R_RESOLVED = ? WHERE R_ID = ?";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, username);
			java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			pdsmt.setDate(2, sqlDate);
			pdsmt.setInt(3, reqID);
			pdsmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void reject(int reqID, String username) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE ER_REIMBURSTMENTS SET R_STATUS = 'rejected', R_RESOLVER= ?, R_RESOLVED = ? WHERE R_ID = ?";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, username);
			java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			pdsmt.setDate(2, sqlDate);
			pdsmt.setInt(3, reqID);
			pdsmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}

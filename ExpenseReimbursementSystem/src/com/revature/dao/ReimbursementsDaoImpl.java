package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursementsDaoImpl implements ReimbursementsDao {

	@Override
	public List<Reimbursements> getReimbursements() {
		List<Reimbursements> ul = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM REIMBURSEMENTS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int rId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				int type = rs.getInt("RT_TYPE");
				int status = rs.getInt("RT_STATUS");
				int author = rs.getInt("U_ID_AUTHOR");
				int resolver = rs.getInt("U_ID_RESOLVER");
				ul.add(new Reimbursements(rId, amount, description, type, status, author, resolver));
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public Reimbursements getReimbursementsById(int r_Id) {
		PreparedStatement pStatement;
		Reimbursements r = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_ID = ?";
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, r_Id);
			ResultSet rs = pStatement.executeQuery();

			while (rs.next()) {
				int rId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				int type = rs.getInt("RT_TYPE");
				int status = rs.getInt("RT_STATUS");
				int author = rs.getInt("U_ID_AUTHOR");
				int resolver = rs.getInt("U_ID_RESOLVER");
				r = new Reimbursements(rId, amount, description, type, status, author, resolver);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void createReimbursement(int r_amount, String r_description, int u_id_author,int rt_type) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "INSERT INTO REIMBURSEMENTS (R_ID,R_AMOUNT,R_DESCRIPTION,U_ID_AUTHOR,"
					+ "U_ID_RESOLVER,RT_TYPE,RT_STATUS)" + " VALUES(SQ_REIMBURSEMENTS_PK.nextval,?,?,?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, r_amount);
			pStatement.setString(2, r_description);
			pStatement.setInt(3, u_id_author);
			pStatement.setInt(4, 1);
			pStatement.setInt(5, rt_type);
			pStatement.setInt(6, 1);
			if (pStatement.executeUpdate() > 0)
				System.out.println("Reimbursement Created.");
			else
				System.out.println("Failed to create Reimbursement.");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void approveReimbursement(int r_Id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "UPDATE REIMBURSEMENTS SET RT_STATUS = ? WHERE R_ID = ?";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, 2);
			pStatement.setInt(2, r_Id);
			if (pStatement.executeUpdate() > 0)
				System.out.println("Reimbursement Approved.");
			else
				System.out.println("Reimbursement Failed to approve.");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void denyReimbursement(int r_Id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "UPDATE REIMBURSEMENTS SET RT_STATUS = ? WHERE R_ID = ?";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, 3);
			pStatement.setInt(2, r_Id);
			if (pStatement.executeUpdate() > 0)
				System.out.println("Reimbursement Denied.");
			else
				System.out.println("Reimbursement fail to deny.");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}

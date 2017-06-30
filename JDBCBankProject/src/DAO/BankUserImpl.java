package DAO;

import java.sql.*;
import java.util.*;
import Domain.*;
import Util.*;

public class BankUserImpl implements BankUserDAO {

	public BankUserImpl() {
	}

	@Override
	public List<BankUser> getBankUsers() {
		ArrayList<BankUser> users = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_USERS";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			ResultSet rs = pdsmt.executeQuery();
			while (rs.next()) {
				users.add(new BankUser(rs.getString("USER_NAME"), rs.getString("USER_PASSWORD")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean addUser(String username, String password) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = new String("SELECT * FROM BANK_USERS WHERE USER_NAME = ? ");
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setString(1, username);
			ResultSet rs = ptsmt.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				sql = new String("INSERT INTO BANK_USERS (USER_NAME,USER_PASSWORD) VALUES (?,?)");
				ptsmt = con.prepareStatement(sql);
				ptsmt.setString(1, username);
				ptsmt.setString(2, password);
				ptsmt.execute();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

}

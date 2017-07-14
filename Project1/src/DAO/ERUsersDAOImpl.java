package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CustomExceptions.InvalidNameException;
import CustomExceptions.UserNameTakenException;
import Domain.ERUser;
import Util.ConnectionUtil;

public class ERUsersDAOImpl implements ERUsersDAO {

	public ERUsersDAOImpl() {
	}

	@Override
	public List<ERUser> getUsers() {
		ArrayList<ERUser> users = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ER_USERS";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			ResultSet rs = pdsmt.executeQuery();
			while (rs.next()) {
				users.add(new ERUser(rs.getString("U_EMAIL"), rs.getString("U_PASSWORD"), rs.getString("U_FIRSTNAME"),
						rs.getString("U_LASTNAME"), rs.getString("U_ROLE")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public ERUser getUserByEmail(String email) {

		return null;
	}

	@Override
	public boolean addUser(ERUser newUser) throws UserNameTakenException, InvalidNameException {
		if (newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty() || newUser.getFirstname().isEmpty()
				|| newUser.getLastname().isEmpty()) {
			throw new InvalidNameException();
		}
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ER_USERS WHERE U_EMAIL = ? ";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, newUser.getEmail());
			ResultSet rs = pdsmt.executeQuery();
			if (rs.next()) {
				throw new UserNameTakenException();
			} else {
				sql = "INSERT INTO ER_USERS VALUES (? , ? , ? , ? , ?)";
				pdsmt = con.prepareStatement(sql);
				pdsmt.setString(1, newUser.getEmail());
				pdsmt.setString(2, newUser.getPassword());
				pdsmt.setString(3, newUser.getFirstname());
				pdsmt.setString(4, newUser.getLastname());
				pdsmt.setString(5, newUser.getRole());
				pdsmt.execute();
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(String username, String toChange, String newVal) throws InvalidNameException {
		if (toChange.isEmpty()) {
			throw new InvalidNameException();
		}
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql;
			PreparedStatement pdsmt;
			switch (toChange) {
			case "password":
				sql = "UPDATE ER_USERS SET U_PASSWORD = ?  WHERE  U_EMAIL = ?";
				break;
			case "fname":
				sql = "UPDATE ER_USERS SET U_FIRSTNAME = ?  WHERE  U_EMAIL = ?";
				break;
			case "lname":
				sql = "UPDATE ER_USERS SET U_LASTNAME = ?  WHERE  U_EMAIL = ?";
				break;
			default:
				return false;
			}
			pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, newVal);
			pdsmt.setString(2, username);
			pdsmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}

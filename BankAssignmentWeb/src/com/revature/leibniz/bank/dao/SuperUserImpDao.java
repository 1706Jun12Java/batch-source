package com.revature.leibniz.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.leibniz.bank.domain.SuperUser;
import com.revature.leibniz.bank.util.ConnectionUtil;

public class SuperUserImpDao implements SuperUserDao {

	@Override
	public List<SuperUser> getSuperUsers() {
		ArrayList<SuperUser> superUsers = new ArrayList<>();

		try {

			// Connect to database
			Connection con = ConnectionUtil.getConnection();

			// Query
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM SUPER_USER_TABLE");

			// iterate through resultSet
			while (resultSet.next()) {
				int superUserID = resultSet.getInt("SUPER_USER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				int personID = resultSet.getInt("PERSON_ID");

				// get super user info
				SuperUser superUser = new SuperUser(superUserID, username, password, personID);

				// add to super user list
				superUsers.add(superUser);
			}
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return superUsers;

	}

	@Override
	public SuperUser getSuperUserByID(int id) {
		SuperUser superUser = null;
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();

			// Query
			String query = "SELECT * FROM SUPER_USER_TABLE WHERE SUPER_USER_ID = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);

			// Get result
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// Get info
				int superUserID = resultSet.getInt("SUPER_USER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				int personID = resultSet.getInt("PERSON_ID");

				// store info to user
				superUser = new SuperUser(superUserID, username, password, personID);
			}
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return superUser;
	}

	@Override
	public int createSuperUser(SuperUser superUser) {
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();

			// Get super user info
			int superUserID = superUser.getSuperUserID();
			String username = superUser.getUsername();
			String password = superUser.getPassword();
			int personID = superUser.getPersonID();
			
			// SubQuery
			String subQuery = "(SELECT PERSON_ID FROM PERSON_TABLE WHERE PERSON_ID = ?)";

			// QUERY
			String query = "INSERT INTO SUPER_USER_TABLE VALUES(?, ?, ?,"+ subQuery +")";
			PreparedStatement statement = con.prepareStatement(query);

			// Insert into query
			statement.setInt(1, superUserID);
			statement.setString(2, username);
			statement.setString(3, password);
			statement.setInt(4, personID);

			// Update query
			statement.executeUpdate();
			
			con.close();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return -1; // Return -1 for error
		}
		return 0; // Return 0 for success
	}

}

package com.revature.leibniz.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.leibniz.bank.domain.User;
import com.revature.leibniz.bank.util.ConnectionUtil;

/**
 * 
 * @author Leibniz Berihuete
 * UserImpDao
 *
 */
public class UserImpDao implements UserDao{

	@Override
	public List<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		
		try {
			
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// Query
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM USER_TABLE");
			
			// iterate through resultSet
			while(resultSet.next()) {
				int userID = resultSet.getInt("USER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				int personID = resultSet.getInt("PERSON_ID");
				
				// get user info
				User user = new User(userID, username, password, personID);
				
				// add to user list
				users.add(user);
			}
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserByID(int id) {
		User user = null;
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// Query
			String query = "SELECT * FROM USER_TABLE WHERE USER_ID = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			
			// Get result
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				// Get info
				int userID = resultSet.getInt("USER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				int personID = resultSet.getInt("PERSON_ID");
				
				// store info to user
				user = new User(userID, username, password, personID);
			}
			
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int createUser(User user) {
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// Get user info
			int userID = user.getUserID();
			String username = user.getUsername();
			String password = user.getPassword();
			int personID = user.getPersonID();
			
			// SubQuery
			String subQuery = "(SELECT PERSON_ID FROM PERSON_TABLE WHERE PERSON_ID = ?)";
			
			//QUERY
			String query = "INSERT INTO USER_TABLE VALUES(?, ?, ?, " + subQuery + ")";
			PreparedStatement statement = con.prepareStatement(query);
			
			
			
			// Insert into query
			statement.setInt(1, userID);
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

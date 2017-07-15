package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ers.domain.UserModel;
import com.ers.util.ConnectionUtil;

public class UserDaoLogic implements UserDao {

	@Override
	public UserModel getUser(int userId) {
		UserModel userInfo = null;
		String sql = "SELECT * FROM ERS_USERS WHERE U_ID = ?";

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int uId = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int userRoleId = rs.getInt("UR_ID");
				
				userInfo = new UserModel(uId, username, firstName, lastName, email, userRoleId);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return userInfo;
		
	}

	@Override
	public int login(String username, String password) {
		int userId = 0;
		String sql = "SELECT * FROM ERS_USERS WHERE U_USERNAME=? AND U_PASSWORD=?";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, username);
			pstmt.setString(2, password);
						
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("U_ID");
				return userId;
			}
		}catch(SQLException e){
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
		return userId;
	}

//	@Override
//	public void logout() {
//		
//	}

	@Override
	public List<UserModel> getEmployeeList(int managerId) {
		List<UserModel> users = null;
		String sql = "SELECT * FROM ERS_USERS";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int uId = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int userRoleId = rs.getInt("UR_ID");
				
				users.add(new UserModel(uId, username, firstName, lastName, email, userRoleId));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int updateEmail(int userId, String email) {
		int updateEmailSuccess = 0;
		String sql = "UPDATE ERS_USERS " +
		"SET U_EMAIL = ? " + 
		"WHERE U_ID = ?";
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			con.setAutoCommit(false);
			
			pstmt.setString(1, email);
			pstmt.setInt(2, userId);
			updateEmailSuccess = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return updateEmailSuccess;
	}

	@Override
	public int updatePassword(int userId, String password) {
		int updatePasswordSuccess = 0;
		String sql = "UPDATE ERS_USERS " +
		"SET U_PASSWORD = ? " + 
		"WHERE U_ID = ?";
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				PreparedStatement pstmt = con.prepareStatement(sql)){
			con.setAutoCommit(false);
			pstmt.setString(1, password);
			pstmt.setInt(2, userId);
			updatePasswordSuccess = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return updatePasswordSuccess;
		
		
		
		
		
	}
	

}

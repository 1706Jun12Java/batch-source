package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.User;
import com.revature.exceptions.WrongCredentialsException;
import com.revature.util.ConnectionUtil;

public class ERUserDaoImpl implements ERUserDao{

	public ERUserDaoImpl() {}

	@Override
	public List<User> getEmployees() {
		List<User> users = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT U_ID,U_USERNAME,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID FROM ERS_USER";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int userId = rs.getInt("U_ID");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String userName = rs.getString("U_USERNAME");
				String email = rs.getString("U_EMAIL");
				int type = rs.getInt("UR_ID");
				User u = new User(userId, userName, firstName,lastName, email, type);
				users.add(u);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User loginUser(String username, String password) throws WrongCredentialsException {
		
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT U_ID,U_USERNAME,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID FROM ERS_USER WHERE U_USERNAME=? AND U_PASSWORD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()){
				throw new WrongCredentialsException();
			}else{
				int userId = rs.getInt("U_ID");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String userName = rs.getString("U_USERNAME");
				String email = rs.getString("U_EMAIL");
				int type = rs.getInt("UR_ID");
				User u = new User(userId, userName, firstName,lastName, email, type);
				return u;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int upDateUserInfo(String password, String firstName,String lastName, int userID) {
		int updated = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE ERS_USER SET U_PASSWORD=?,U_FIRSTNAME=?,U_LASTNAME=? WHERE U_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setInt(4, userID);
			updated = pstmt.executeUpdate();
			System.out.println("tried to update user with status code"+updated);;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		return updated;
		
	}

	@Override
	public int registerEmployee(User user) {
		int add = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "INSERT INTO ERS_USER (U_USERNAME,U_PASSWORD,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID) VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getEmail());
			pstmt.setInt(6, user.getRoleID());
			add = pstmt.executeUpdate();
			System.out.println("tried to add user with status code"+ add);;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		return add;
	}

	@Override
	public int sendApproveEmail(int reimID, String fromEmail, String toEmail) {
		int send = 0;
		return send;
	}

	@Override
	public int sendAccountEmail(String fromEmail, User u) {
		int send = 0;
		
		return send;
	}

	@Override
	public User getUserById(int id) throws WrongCredentialsException {
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT U_ID,U_USERNAME,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID FROM ERS_USER WHERE U_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()){
				throw new WrongCredentialsException();
			}else{
				int userId = rs.getInt("U_ID");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String userName = rs.getString("U_USERNAME");
				String email = rs.getString("U_EMAIL");
				int type = rs.getInt("UR_ID");
				User u = new User(userId, userName, firstName,lastName, email, type);
				return u;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}

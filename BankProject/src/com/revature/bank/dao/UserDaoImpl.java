package com.revature.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.revature.bank.domain.SuperUser;
import com.revature.bank.domain.User;
import com.revature.bank.exception.UniqueIDException;
import com.revature.bank.exception.WrongCredentialException;
import com.revature.bank.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	public UserDaoImpl(){};

	public int createUser(User user) throws UniqueIDException{
		int userCreated = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO BANK_USER (USERNAME,PW)"
					+" VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			userCreated = pstmt.executeUpdate();
			System.out.println(userCreated);
			con.commit();
		} catch(SQLException e){
			try {
				con.rollback();
				throw new UniqueIDException();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		return userCreated;
	}

	@Override
	public User getUserByCredential(String username, String password) throws WrongCredentialException{
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME=? AND PW=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()){
				throw new WrongCredentialException();
			}else{
				int userId = rs.getInt("USER_ID");
				int type = rs.getInt("USER_TYPE");
				String userName = rs.getString("USERNAME");
				String pw = rs.getString("PW");
				if(type==0){
					return new User(userId, userName, pw, type);
				}else if(type==1){
					return new SuperUser(userId, userName, pw, type);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
}

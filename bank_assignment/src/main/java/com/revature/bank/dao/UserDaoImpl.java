package com.revature.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.bank.domain.SuperUser;
import com.revature.bank.domain.User;
import com.revature.bank.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	public UserDaoImpl(){};

	public int createUser(User user) throws UniqueConstraintException{
		int userCreated = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO BANK_USER (USERNAME,PW)"
					+" VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			userCreated = pstmt.executeUpdate();
			con.commit();
			if(userCreated==0){
				throw new UniqueConstraintException();
			}
			
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("username is taken");
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return userCreated;
	}

	@Override
	public User getUserByCredential(String username, String password) throws WrongCredentialException{
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
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

 class WrongCredentialException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WrongCredentialException(){
		super("Wrong username or password");
	}
	
}
 
 class UniqueConstraintException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6986035852343129136L;
	public UniqueConstraintException(){
		super("User already taken");
	}
 }

package com.chase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chase.util.ConnectionUtil;

public class LoginDaoImpl implements LoginDao{
	
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		Connection con= ConnectionUtil.getConnectionFromFile();  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from USER_S where USER_NAME=? and PASS_WORD=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  

}

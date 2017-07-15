package com.bank.dao;

import java.util.List;

import com.bank.domain.User;

public interface UserDao {
	
	public static boolean validateEmployee(String name,String pass){
		return false;
	}
	public static boolean validateManager(String name,String pass){
		return false;
	}
	public static List<User> getAllEmployees(){
		return null;
		}
	public static int getUserByUsername(String username){
		return 0;
	}
	public static User getUserById(int id){
		return null;
	}
	public static User viewEmployeeInfo(){
		return null;
	}
	public static void updateEmployeeUsername(String username, int id) {
		}
	public static void updateEmployeePassword(String username, int id) {
	}
	public static void updateEmployeeFirstName(String username, int id) {
	}
	public static void updateEmployeeLastName(String username, int id) {
	}
	public static void updateEmployeeEmail(String username, int id) {
	}
	

}

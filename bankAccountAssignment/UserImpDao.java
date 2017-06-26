package com.revature.leibniz.bankAccountAssignment;

import java.util.ArrayList;
/**
 * 
 * @author Leibniz Berihuete
 * User Implements Dao
 */
public class UserImpDao implements UserDao {
	private ArrayList<User> userList;

	public UserImpDao() {
		userList = new ArrayList<>();
		
	}
	
	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User getUser(int userID) {
		User user = null;
		for(int i = 0; i < userList.size(); i++) {
			if(user.getUserID() == userList.get(i).getUserID()) {
				user = userList.get(i);
				break;
			}
		}
		return user;
	}

	@Override
	public void deleteUser(int userID) {
		int index = userList.indexOf(getUser(userID));
		if(index >=0) {
			userList.remove(index);
		}
	}

}

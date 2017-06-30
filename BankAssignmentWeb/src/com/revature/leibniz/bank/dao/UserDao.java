package com.revature.leibniz.bank.dao;
import java.util.List;

import com.revature.leibniz.bank.domain.User;

/**
 * 
 * @author Leibniz Berihuete
 * User Dao
 */
public interface UserDao {
	public List<User> getUsers();
	public User getUserByID(int id);
	public int createUser(User user);
}

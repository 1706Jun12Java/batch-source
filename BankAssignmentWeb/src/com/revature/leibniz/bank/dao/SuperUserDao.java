package com.revature.leibniz.bank.dao;

import java.util.List;

import com.revature.leibniz.bank.domain.SuperUser;

/**
 * 
 * @author Leibniz Berihuete
 * Super User Dao
 */
public interface SuperUserDao {
	public List<SuperUser> getSuperUsers();
	public SuperUser getSuperUserByID(int id);
	public int createSuperUser(SuperUser superUser);
}

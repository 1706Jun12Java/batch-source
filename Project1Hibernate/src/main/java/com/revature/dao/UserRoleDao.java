package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface UserRoleDao {
	public List<UserRoles> getUserRoles();
	public UserRoles getUserRoleById(int id);
	public int saveUserRole(UserRoles b);
}

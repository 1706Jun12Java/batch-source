package com.revature.dao;

/**
 * Created by John on 7/9/2017.
 */
public interface UserRoleDao
{
    boolean addUserRole(String role);
    boolean getUserRoleById(int id);
}

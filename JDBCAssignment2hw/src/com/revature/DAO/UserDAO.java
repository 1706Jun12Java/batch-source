package com.revature.DAO;

import com.revature.model.User;


/**
 * Created by John on 6/24/2017.
 */
public interface UserDAO
{
    User createUser(String fName, String lName, String username, String password);

    User getUserByUsername(String username);

    User getUserById(int userId);
}

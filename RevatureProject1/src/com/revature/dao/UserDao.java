package com.revature.dao;

import com.revature.models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.List;

public interface UserDao
{
    User createUser(String username, String password, String email, String firstName, String lastName, int role) throws SQLException;

    User getUserById(int id) throws SQLException;

    User getUserByUsername(String username) throws SQLException;

    List<User> getUsers();

    static String hashPassword(String password)
    {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    static boolean checkPassword(String password, String hashed)
    {
        return BCrypt.checkpw(password, hashed);
    }

    User auth(String username, String password) throws SQLException;

    boolean deleteUser(int id);
}
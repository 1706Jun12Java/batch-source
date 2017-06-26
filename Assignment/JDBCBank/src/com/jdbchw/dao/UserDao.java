package com.jdbchw.dao;

import com.jdbchw.domain.Account;
import com.jdbchw.domain.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User getUserById(int id);
    void createUser(String username, String password, String email);
    void createAccount(User user);
    void deleteAccount(User user, int accountNumber);
    List<Account> getAllBalances(User user);
    void withdraw(User user, int accountId, double withdraw);
    void deposit(User user, int accountId, int deposit);

}

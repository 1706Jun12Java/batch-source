package com.bank.dao;

import java.util.List;

import com.bank.user.Account;
import com.bank.user.User;

public interface UserDao {
	
    List<User> getUsers();
    User getUserById(int id);
    boolean createUser(String username, String password, String email);
    void createAccount(User user);
    void deleteAccount(User user, int accountNumber);
    List<Account> getAllBalances(User user);
    boolean withdraw(User user, int accountId, int withdraw);
    boolean deposit(User user, int accountId, int money);
    boolean deleteAllUser(User user);
    boolean updateUser(int user, String username, String password, String email);
    
}

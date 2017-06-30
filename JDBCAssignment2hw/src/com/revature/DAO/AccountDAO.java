package com.revature.DAO;

import com.revature.model.Account;

import java.util.List;

/**
 * Created by John on 6/24/2017.
 */
public interface AccountDAO
{
    Account createAccount(int userID, int accountType);

    Account getAccountById(int userID, int accountType);

    List<Account> getAccounts(int userId);

    boolean isTypeAvailable(int userId, int accountType);

    boolean deposit(int amount, int userId, int accountType);

    int withdraw(int amount, int userId, int accountType);

    boolean deleteAccount(int userId, int accountType);
}
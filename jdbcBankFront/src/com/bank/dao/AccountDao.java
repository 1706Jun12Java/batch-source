package com.bank.dao;

import java.util.List;

import com.bank.user.Account;

public interface AccountDao {
    List<Account> getAccount();
    Account getAccountID(int id);
}

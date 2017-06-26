package com.jdbchw.dao;

import com.jdbchw.domain.Account;
import com.jdbchw.domain.User;

import java.util.List;

public interface AccountDao {

    List<Account> getAccount();
    Account getAccountID(int id);

}

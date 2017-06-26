package com.jdbcbank.dao;

import java.util.*;
import com.jdbcbank.domain.*;

public interface AccountDao {
	public List<Account> getUserAcount(User u);
	public void createAccount(User u);
	public void deleteAccount(Account a);
	public void depositeAccount(Account a, float money);
	public void withdrowAccount(Account a, float money);  
}

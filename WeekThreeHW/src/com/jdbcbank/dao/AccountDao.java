package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import com.jdbcbank.domain.*;

public interface AccountDao {
	public List<Account> getUserAccount(User u) throws SQLException, IOException;
	public void createAccount(Account a) throws SQLException, IOException;
	public void deleteAccount(Account a) throws SQLException, IOException;
	public void depositAccount(Account a, float money) throws SQLException, IOException;
	public void withdrowAccount(Account a, float money) throws SQLException, IOException;  
}
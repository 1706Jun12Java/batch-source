package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import com.jdbcbank.domain.*;

public interface TransactionDao {
	public void addTransaction(Transaction t) throws SQLException, IOException ;
	public List<Transaction> getTransaction(Account a) throws SQLException, IOException;
}
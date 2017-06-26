package com.jdbcbank.dao;

import java.util.*;
import com.jdbcbank.domain.*;

public interface TransactionDao {
	public void addTransaction(Transaction t);
	public List<Transaction> getTransaction(Account a);
}

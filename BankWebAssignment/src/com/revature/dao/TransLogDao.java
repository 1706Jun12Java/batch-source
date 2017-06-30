package com.revature.dao;

import java.util.List;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.TransLog;

public interface TransLogDao {
	public TransLog getLog(int ID) throws InvalidAccountException, InvalidUsernameException;
	List<TransLog> getAllTransactions(int ID) throws InvalidUsernameException, InvalidAccountException;
}

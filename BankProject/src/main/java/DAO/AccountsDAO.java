package DAO;

import UserDefinedExceptions.BadLoginException;

public interface AccountsDAO {

	public void run(String username, String password) throws BadLoginException;

}

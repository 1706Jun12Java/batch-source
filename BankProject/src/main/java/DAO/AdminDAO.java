package DAO;

import UserDefinedExceptions.BadLoginException;

public interface AdminDAO {
	public void run(String username, String password) throws BadLoginException;

}

package com.revature.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.revature.Exceptions.InvalidReimburstmentException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.Reimburstment;

public interface ReimburstmentDao {
	public List<Reimburstment> getReimburstmentByUser(int userID) throws InvalidReimburstmentException,InvalidUsernameException, SQLException;
	public List<Reimburstment> getAllReimburstments() throws InvalidReimburstmentException, SQLException, InvalidUsernameException;
	public void deleteReimburstment(int reimburstmentID)throws InvalidReimburstmentException, SQLException;
	void sendReimburstmet(int userID, Double amount, String description, String pic, String type)
			throws InvalidReimburstmentException, SQLException;
	void updateReimburstment(int reimburstmentID, String approval,int managerID)
			throws InvalidReimburstmentException, SQLException;
}

package com.revature.dao;

import java.util.List;

import com.revature.domain.Status;

public interface StatusDao {
	public List<Status> getStatuses();
	public Status getStatusById(int id);
	public int saveStatus(Status b);
}

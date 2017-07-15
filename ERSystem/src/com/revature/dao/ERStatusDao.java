package com.revature.dao;

import java.util.List;

import com.revature.domain.ReStatus;

public interface ERStatusDao {

	public List<ReStatus> getReStatusList();
	public ReStatus getStatusById(int id);
}

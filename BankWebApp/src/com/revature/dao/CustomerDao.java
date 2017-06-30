package com.revature.dao;

import java.util.List;

import com.revature.domain.Customer;

public interface CustomerDao {
	
	public void insertCustomer();
	public List<Customer> getCustomers();
}

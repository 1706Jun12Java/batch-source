package com.bank.dao;

import java.util.List;

import com.bank.domain.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public Customer createCustomer(int id, String firstname, String lastname, String username, String password);
}

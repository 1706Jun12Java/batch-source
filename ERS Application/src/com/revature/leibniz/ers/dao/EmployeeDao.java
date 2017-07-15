package com.revature.leibniz.ers.dao;

import java.util.List;

import com.revature.leibniz.ers.domain.Employee;
/**
 * 
 * @author Leibniz Berihuete
 * Employee DAO Interface, this will be implemented by EmployeeImpDao
 */
public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee findEmployeeByID(int id);
	public int createEmployee(Employee employee);
}

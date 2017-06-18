package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class SortEmployees {

	public static void main(String[] args) {
		
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee("Kevin","Science",29));
		list.add(new Employee("Kevin","Account",17));
		
		System.out.println("Employees before sort:");
		for(Employee e: list)
			System.out.println(e.toString());
		
		EmployeeCompare ec = new EmployeeCompare();
		Collections.sort(list, ec);
		System.out.println("Employees after sort:");
		for(Employee e: list)
			System.out.println(e.toString());
	}

}
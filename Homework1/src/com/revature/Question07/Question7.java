package com.revature.Question07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question7 {
	
	public static void main(String[] args) {
		
		Employee john = new Employee("John", 30, "IT");
		Employee muhammad = new Employee("Muhammad", 24, "IT");
		Employee abhishek = new Employee("Abhishek", 26, "Sales");
		Employee diego = new Employee("Diego", 26, "Sales");
		Employee michael = new Employee("Michael", 21, "Graduate Sales");
		Employee keegan = new Employee("Keegan", 26, "Management");
		Employee janice = new Employee("Janice", 21, "Verizon");
		Employee billy = new Employee("Billy", 32, "Management");
		Employee michelle = new Employee("Michelle", 30, "Sales");
		
		
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add(john);
		listEmployees.add(muhammad);
		listEmployees.add(abhishek);
		listEmployees.add(janice);
		listEmployees.add(keegan);
		listEmployees.add(billy);
		listEmployees.add(diego);
		listEmployees.add(michael);
		listEmployees.add(michelle);
		
		
		
		System.out.println("Original order: ");
		for(Employee e : listEmployees){
			System.out.println(e);
		}
		
		Collections.sort(listEmployees, Employee.compareName.instance);
		System.out.println("\n\nSorted by Name:");
		for(Employee e: listEmployees){
			System.out.println(e);
		}
		
		Collections.sort(listEmployees, Employee.CompareAge.instance);
		System.out.println("\n\nSorted by Age: ");
		for(Employee e: listEmployees){
			System.out.println(e);
		}
		
		Collections.sort(listEmployees, Employee.CompareDepartment.instance);
		System.out.println("\n\nSorted by Department: " );
		for(Employee e: listEmployees){
			System.out.println(e);
		}
		
		
	}

}

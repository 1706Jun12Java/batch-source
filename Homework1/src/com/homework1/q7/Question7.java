package com.homework1.q7;

import java.util.Arrays;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("Alex Wings","history",37);
		Employee e2 = new Employee("Alex Wings","math", 36);
		Employee e3 = new Employee("Alex Wings","math", 35);
		Employee e4 = new Employee("Alex Chicken","math", 36);
		Employee[] employeeArray = {e1, e2,e3,e4};
		Arrays.sort(employeeArray);
		System.out.println(Arrays.toString(employeeArray));
		
	}

}

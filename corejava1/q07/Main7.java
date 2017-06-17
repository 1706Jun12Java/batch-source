package corejava1.q07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Leibniz Berihuete 
 * QUESTION 7: 
 *   Sort two employees based on their name,
 *   department, and age using the Comparator interface.
 * 
 *
 */
public class Main7 {
	public static void main(String[] args) {
		// Create two employees
		Employee person1 = new Employee("Leibniz", "Berihuete", "Software Engineer", 26);
		Employee person2 = new Employee("Robert", "Ash", "Quality Control", 28);
		//Employee person3 = new Employee("James", "Crique", "HR", 23);

		// Store the two employees in ArrayList
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(person1);
		employeeList.add(person2);
		//employeeList.add(person3);

		// SORTING by First Name;
		System.out.println("SORTING by FIRST NAME");
		Collections.sort(employeeList, EmployeeComparator.FIRST_NAME);
		System.out.println(employeeList);
		System.out.println("----------------------------------------");

		// SORTING by Last Name;
		System.out.println("SORTING by LAST NAME");
		Collections.sort(employeeList, EmployeeComparator.LAST_NAME);
		System.out.println(employeeList);
		System.out.println("----------------------------------------");
		
		
		// SORTING by Department;
		System.out.println("SORTING by DEPARTMENT");
		Collections.sort(employeeList, EmployeeComparator.DEPARTMENT);
		System.out.println(employeeList);
		System.out.println("----------------------------------------");
		
		
		// SORTING by Department;
		System.out.println("SORTING by AGE");
		Collections.sort(employeeList, EmployeeComparator.AGE);
		System.out.println(employeeList);
		System.out.println("----------------------------------------");
		
		
	}
}

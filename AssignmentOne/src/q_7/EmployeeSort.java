package q_7;

import java.util.*;

//Sort two employees based on their name, department,
//and age using the Comparator interface.
public class EmployeeSort {

	public String name;
	public String department;
	public int age;
	
	//Default constructor
	EmployeeSort() {
		super();
	}
	
	//Constructor we want to use.
	EmployeeSort(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//Used so we don't get the reference back, instead the actual information we want.
	@Override
	public String toString() {
		return "Name: " + name + " Department: " + department + " Age: " + age;
	}

	//Using comparator to compare emp1 with emp2 for sort.
	static class SortAge implements Comparator<EmployeeSort> {

		@Override
		public int compare(EmployeeSort emp1, EmployeeSort emp2) {
			return emp1.age - emp2.age;
		}

	}

	static class SortDepartment implements Comparator<EmployeeSort> {

		@Override
		public int compare(EmployeeSort emp1, EmployeeSort emp2) {
			return emp1.department.compareTo(emp2.department);
		}
	}

	static class SortName implements Comparator<EmployeeSort> {

		@Override
		public int compare(EmployeeSort emp1, EmployeeSort emp2) {
			return emp1.name.compareTo(emp2.name);
		}
	}

	public static void main(String[] args) {

		String name = "Lisa", department = "Finance";
		int age = 32;
		
		//Make an arraylist to store emp and sort.
		ArrayList<EmployeeSort> empList = new ArrayList<EmployeeSort>();

		//creating and adding emp to the list.
		EmployeeSort firstEmp = new EmployeeSort(name, department, age);
		empList.add(firstEmp);

		name = "John";
		department = "HR";
		age = 29;

		EmployeeSort secondEmp = new EmployeeSort(name, department, age);
		empList.add(secondEmp);

		System.out.println("List of Employee unsorted");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));

		//sorting by age
		Collections.sort(empList, new SortAge());

		//displaying arraylist after it is sorted by age. 
		System.out.println("\nList of Employee Sorted by Age");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));

		Collections.sort(empList, new SortDepartment());

		System.out.println("\nList of Employee Sorted by Department");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));

		Collections.sort(empList, new SortName());

		System.out.println("\nList of Employee Sorted by Name");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
	}
}

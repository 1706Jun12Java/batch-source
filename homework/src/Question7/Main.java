package Question7;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//create array list to hold your employees
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Zack","IT",35));
		empList.add(new Employee("Amanda","Marketing",24));
		empList.add(new Employee("Samantha","Sales",47));
		empList.add(new Employee("Peter","Engineering",61));
		empList.add(new Employee("Christopher","Sales",30));
		
		//instantiate compare classes
		NameCompare name = new NameCompare();
		DepartmentCompare department = new DepartmentCompare();
		AgeCompare age = new AgeCompare();
		
		//Print list before sorting
		System.out.println("List of Employees before sort: ");
		for (Employee e : empList){
			System.out.print(e.toString());
		}
		System.out.println("");
		
		//Sort by name,department, and age
		System.out.println("Here are the employees sorted by name: ");
		Collections.sort(empList,name);
		for (Employee e : empList){
			System.out.print(e.toString());
		}
		System.out.println("");
		System.out.println("Here are the employees sorted by department: ");
		Collections.sort(empList,department);
		for (Employee e : empList){
			System.out.print(e.toString());
		}
		System.out.println("");
		System.out.println("Here are the employees sorted by age: ");
		Collections.sort(empList,age);
		for (Employee e : empList){
			System.out.print(e.toString());
		}
	}
}

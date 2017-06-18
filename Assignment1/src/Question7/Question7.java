package Question7;

import java.util.*;

public class Question7 {

	public static void main(String[] args) {
		// Initialize an ArrayList and assign values
		ArrayList<Employee> employees = new ArrayList<Employee>();

		employees.add(new Employee("Production", "John", 62));
		employees.add(new Employee("Research and Development", "Max", 35));

		System.out.println("Starting...");
		for (Employee e : employees) {
			System.out.println(e);
		}
		// sort using the various Comparators
		Collections.sort(employees, new SortByName());
		System.out.println("Sorted by name");
		for (Employee e : employees) {
			System.out.println(e);
		}
		System.out.println("Sorted by age");
		Collections.sort(employees, new SortByAge());
		for (Employee e : employees) {
			System.out.println(e);
		}
		Collections.sort(employees, new SortByDepartment());
		System.out.println("Sorted by department");
		for (Employee e : employees) {
			System.out.println(e);
		}

	}

}

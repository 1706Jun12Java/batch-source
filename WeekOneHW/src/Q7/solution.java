package Q7;

import java.util.*;

public class solution {

	// Sort two employees based on their name, department, and age using the
	// Comparator interface.

	public static void main(String[] args) {

		Employee e1 = new Employee("Alice", "CS", 20);
		Employee e2 = new Employee("Alice", "BS", 30);

		Employee[] employeeList = {e1, e2}; 

		System.out.println("Before Sorting");
		for (Employee e : employeeList)
			System.out.println(e );
		
		Arrays.sort(employeeList, new comparetorClass());

		System.out.println("\nAfter Sorting");
		for (Employee e : employeeList)
			System.out.println(e );
	}  
} 

class Employee {
	public String name;
	public String department;
	public int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "[Name="+this.name+", Department="+this.department+", age="+this.age+"]";		
	}
 
}


class comparetorClass implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.name.compareToIgnoreCase(e2.name) == 0) {
			if (e1.department.compareToIgnoreCase(e2.department) == 0) {
				if (e1.age > e2.age) {
					return 1;
				} else if (e1.age < e2.age) {
					return -1;
				} else
					return 0;
			} else
				return e1.department.compareToIgnoreCase(e2.department);
		} else
			return e1.name.compareToIgnoreCase(e2.name);
	}
	
}
package Question7;

import java.util.*;

class EmployeeSort {

	public static void main(String[] args) {

		ArrayList<Employee> sorted = new ArrayList();

		Employee one = new Employee("John", "IT", 23);
		sorted.add(one);

		Employee two = new Employee("Matt", "Accounting", 24);

		Employee zero = new Employee("A", "B", 1);

		sorted.add(two);

		sorted.add(zero);

		//Collections.sort(sorted, new AgeCompare());

		Collections.sort(sorted, new NameCompare() );
		
		
		for (Employee a : sorted)
			System.out.println(a.name);

	}

}

class Employee {

	String name;
	String department;
	int age;

	Employee(String nam, String departmen, int ag) {
		this.name = nam;
		this.department = departmen;
		this.age = ag;
	}

}

class AgeCompare implements Comparator<Employee> {

	public int compare(Employee one, Employee two) {

		return one.age == two.age ? 0 : one.age > two.age ? -1 : 1;

	}

}

	class NameCompare implements Comparator<Employee> {

		public int compare(Employee one, Employee two) {

			return one.name.compareTo(two.name);

		}

	}
	
	class DepCompare implements Comparator<Employee>{
		
		public int compare(Employee one, Employee two){
			
		return	one.department.compareTo(two.department);
			
			
		}
}
	
	
	

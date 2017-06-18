package question.seven;

import java.util.ArrayList;

public class EmployeeExample {
	
	public static void main(String[] args){
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Sam", "Sales", 24));
		employeeList.add(new Employee("Oliver", "Marketing", 35));
		employeeList.add(new Employee("Zen", "Accounting", 22));
		employeeList.add(new Employee("Ariel", "HR", 49));
		employeeList.add(new Employee("Ariel", "HR", 27));

		
		
		System.out.println("Unsorted employeeList: " + employeeList);
		
		EmployeeComparison ec = new EmployeeComparison();
		employeeList.sort(ec);
		System.out.println("Sorted employeeList: " + employeeList);

		
	}

}

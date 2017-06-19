package Employees;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeesComparator {

	public static void main(String[] args) {
		
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee("Dmitriy", "IT", 25));
		list.add(new Employee("Arthur", "Marketing", 26));
		list.add(new Employee("Albert", "HR", 24));
		
		EmployeeCompare nameCompare = new EmployeeCompare();
		Collections.sort(list, nameCompare);
		System.out.println("Name  Dept    Age");
		for (Employee m : list){
			System.out.println(m.getName()+"  "+m.getDept()+"  "+m.getAge());
	}

}
}

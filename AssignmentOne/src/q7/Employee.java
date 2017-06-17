package q7;
import java.util.*;

public class Employee{
	
	private String name; 
	private String department; 
	private int age; 
	
	Employee(){
		
	}
	
	Employee(String n, String d, int a){
		setName(n); 
		setDepartment(d); 
		setAge(a); 
		
	}

	public static void main(String[] args) {
		// Sort two employees based on their name, department, and age using the Comparator interface.
		ArrayList<Employee> emp = new ArrayList<Employee>();
		Employee e1 = new Employee("Mridula Zaman", "IT", 22);
		emp.add(e1);
		Employee e2 = new Employee("Zaid Khan", "Accounting", 29);
		emp.add(e2);
		
		// Sort by name:
		System.out.println("SORT BY NAME");
		System.out.println("");
		Collections.sort(emp, new NameComparator());
		for(Employee e: emp){
			System.out.println("Name: " + e.name + " | Age: " + e.age + " | Department: " + e.department + " |");
		}
		
		// Sort by department: 
		System.out.println("");
		System.out.println("SORT BY DEPARTMENT");
		System.out.println("");
		Collections.sort(emp, new DepartmentComparator());
		for(Employee e: emp){
			System.out.println("Name: " + e.name + " | Age: " + e.age + " | Department: " + e.department + " |");
		}
		
		// Sort by age: 
		System.out.println("");
		System.out.println("SORT BY AGE");
		System.out.println("");
		Collections.sort(emp, new AgeComparator());
		for(Employee e: emp){
			System.out.println("Name: " + e.name + " | Age: " + e.age + " | Department: " + e.department + " |");
		}
		

	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}


class NameComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}

class AgeComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		return ((Integer)(e1.getAge())).compareTo((Integer)(e2.getAge()));
	}
}

class DepartmentComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
}

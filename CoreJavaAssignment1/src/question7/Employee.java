package question7;

import java.util.Comparator;

public class Employee {
	String name;
	String department;
	int age;
	
	Employee(String name, String department, int age){
		this.name = name;
		this.department = department;
		this.age = age;
	}
	Employee(){
		
	}
	
	public String toString(){
		return "Name: " + name + " Department: " + department + " age: " + age;
	}
}
class SortByName implements Comparator<Employee>{
	 public int compare(Employee a, Employee b)
	    {
	        return a.name.compareTo(b.name);
	    }
	
}
class SortByDepartment implements Comparator<Employee>{
	 public int compare(Employee a, Employee b)
	    {
	        return a.department.compareTo(b.department);
	    }
	
}
class SortByAge implements Comparator<Employee>{
	 public int compare(Employee a, Employee b)
	    {
		 return a.age - b.age;
	    }
	
}

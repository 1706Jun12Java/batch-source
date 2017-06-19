package com.revature.Question07;

import java.util.Comparator;

public class Employee {

	private String name;
	private int age;
	private String department;

	public Employee(String name, int age, String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected String getDepartment() {
		return department;
	}

	protected void setDepartment(String department) {
		this.department = department;
	}

	public static class compareName implements Comparator<Employee> {
		public final static compareName instance = new compareName();
		
		
		private compareName() { }
		
		public int compare(Employee e1, Employee e2){
			return e1.name.compareTo(e2.name);}
	
	
	}
	
	public static class CompareAge implements Comparator<Employee> {
		public final static CompareAge instance = new CompareAge();
		
		
		private CompareAge() { }
		
		public int compare(Employee e1, Employee e2){
			if(e1.getAge()<e2.getAge())
				return -1;
			if(e1.getAge()>e2.getAge()) 
				return 1;
			else 
				return 0;
		}
		
		
	}
	
	public static class CompareDepartment implements Comparator<Employee> {
		public final static CompareDepartment instance = new CompareDepartment();
		
		
		private CompareDepartment() { }
		
		public int compare(Employee e1, Employee e2){
			return e1.department.compareTo(e2.department);}
	
	
	}

	

}

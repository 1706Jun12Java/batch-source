package com.homework1.q7;

public class Employee implements Comparable<Employee>{
	public String name;
	public String department;
	public int age;
	
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}



	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if(this.name!=o.name){
			return this.name.compareTo(o.name);
		}if(this.department!=o.department){
			return this.department.compareTo(o.department);
		}else{
			return this.age-o.age;
		}
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

}

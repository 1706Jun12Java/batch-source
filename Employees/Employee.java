package Employees;

public class Employee implements Comparable<Employee>{
	
	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	private String name;
	private String dept;
	private int age;

	public Employee() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.getName());
	}
}
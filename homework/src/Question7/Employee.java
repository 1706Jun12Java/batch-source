package Question7;


public class Employee {

	//create variables that each employee will have
	private String name;
	private String department;
	private int age;
	
	//create constructor,getters/setters, and toString
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee Name: " + name + ",  Department: " + department + ",  Age: " + age+"\n" ;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}

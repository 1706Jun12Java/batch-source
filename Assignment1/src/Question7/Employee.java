package Question7;

public class Employee {
	// constructor
	public Employee(String department, String name, int age) {
		super();
		this.department = department;
		this.name = name;
		this.age = age;
	}

	// member variables
	private String department;
	private String name;
	private int age;

	// getters/setters
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

	// toString function
	@Override
	public String toString() {
		return "Employee [department=" + department + ", name=" + name + ", age=" + age + "]";
	}

}

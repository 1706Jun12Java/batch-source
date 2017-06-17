package corejava1.q07;

import java.util.Comparator;
/**
 * 
 * @author Leibniz Berihuete
 * 
 *
 */
public class Employee{
	private String firstName;
	private String lastName;
	private String department;
	private int age;
	
	// DEFAULT CONSTRUCTOR
	public Employee () {}
	
	// CONSTRUCTOR (String, String, String, int)
	public Employee(String firstName, String lastName, String department, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.age = age;
	}

	// ACCESSORS
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}

	// MUTATORS
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override public String toString() {
		return "\n" + firstName + " " + lastName + " " + age + " " + department + "\n";
	}
}

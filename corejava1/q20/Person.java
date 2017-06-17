package corejava1.q20;

public class Person {
	String firstName;
	String lastName;
	int age;
	String state;
	
	// DEFAULT CONSTRUCTOR
	public Person() {}
	
	// CONSTRUCTOR(String, String, int, String)
	public Person(String firstName, String lastName, int age, String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
	}
	
	// ======= GETTERS============ //
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getState() {
		return state;
	}

	// ======== SETTERS ========== //
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	// =========== OTHERS ============ //
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Override public String toString() {
		String name = getFullName();
		String str = "\nName: " + name +
		             "\nAge: " + age +
				     "\nState: " + state + "\n\n";
		return str;
	}
	
}

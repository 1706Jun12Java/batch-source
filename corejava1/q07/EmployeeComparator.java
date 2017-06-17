package corejava1.q07;

import java.util.Comparator;

/**
 * 
 * @author Leibniz Berihuete
 * EmployeeComparator 
 * contains the rules of how a collection/list of employee should be sorted
 *
 */
public class EmployeeComparator {
	// FINAL VALUES:
	public static final FirstNameComparator FIRST_NAME = new FirstNameComparator();
	public static final LastNameComparator LAST_NAME = new LastNameComparator();
	public static final DepartmentComparator DEPARTMENT = new DepartmentComparator();
	public static final AgeComparator AGE = new AgeComparator();
	
	
	
	/* **************************************
	 * 		PRIVATE STATIC INNER CLASSES
	 * **************************************/
	
	// FirstName Comparator
	private static class FirstNameComparator implements Comparator<Employee> {
		@Override public int compare(Employee o1, Employee o2) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}		
	}
	
	// LastName Comparator
	private static class LastNameComparator implements Comparator<Employee> {
		@Override public int compare(Employee o1, Employee o2) {
			return o1.getLastName().compareTo(o2.getLastName());
		}		
	}
	
	// Department Comparator
	public static class DepartmentComparator implements Comparator<Employee> {
		@Override public int compare(Employee o1, Employee o2) {
			return o1.getDepartment().compareTo(o2.getDepartment());
		}		
	}
	
	// Age Comparator
	public static class AgeComparator implements Comparator<Employee> {
		@Override public int compare(Employee o1, Employee o2) {
			return (o1.getAge() - o2.getAge());
		}		
	}
}

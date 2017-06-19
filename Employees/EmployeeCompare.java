package Employees;
import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee>{

	public EmployeeCompare() {
		
	}

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
	
}

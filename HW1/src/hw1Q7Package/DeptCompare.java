package hw1Q7Package;

import java.util.Comparator;

public class DeptCompare implements Comparator<Employee>{
	public DeptCompare(){
		
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}

}

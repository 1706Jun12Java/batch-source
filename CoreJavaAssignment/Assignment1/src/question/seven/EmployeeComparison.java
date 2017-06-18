package question.seven;

import java.util.Comparator;

public class EmployeeComparison implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		int cValue = e1.getName().compareTo(e2.getName());
		
		if (cValue!=0){
			return cValue;
		}
		
		cValue = e1.getDepartment().compareTo(e2.getDepartment());
		if (cValue!=0){
			return cValue;
		} 
			else{
			return ((Integer) e1.getAge()).compareTo(e2.getAge());
		
	}

}
}

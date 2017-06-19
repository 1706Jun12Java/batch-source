package question7;

import java.util.Comparator;

class DepartmentComparator <T> implements Comparator<T> {


	public int compare(Object o1, Object o2) {
		
		Employee e1 =(Employee)o1;
		Employee e2 =(Employee)o2;
		return e1.deparment.compareTo(e2.deparment);
	}
}
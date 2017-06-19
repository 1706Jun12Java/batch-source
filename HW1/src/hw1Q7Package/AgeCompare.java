package hw1Q7Package;

import java.util.Comparator;

public class AgeCompare implements Comparator<Employee>{
	public AgeCompare(){
		
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge()-o2.getAge();
	}
	
	

}

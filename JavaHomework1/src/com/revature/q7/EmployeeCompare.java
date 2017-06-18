package com.revature.q7;

import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee>{
		public EmployeeCompare(){
			super();
		}
		public int compare(Employee arg0, Employee arg1){
			if(arg0.getName().compareTo(arg1.getName()) !=0)
				return arg0.getName().compareTo(arg1.getName());
			else if(arg0.getDepartment().compareTo(arg1.getDepartment())!=0)
				return arg0.getDepartment().compareTo(arg1.getDepartment());
			else
				return arg0.getAge()-arg1.getAge();	
		}
}


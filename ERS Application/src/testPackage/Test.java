package testPackage;

import java.util.Scanner;

import com.revature.leibniz.ers.dao.EmployeeImpDao;
import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.util.DataUtil;

public class Test {
	
	public static void main(String [] args) {
		int id = DataUtil.getMaxInt("EMPLOYEE_TABLE", "EMPLOYEE_ID");
		
		// Testing...
		Employee e = new Employee()
				.setID(++id)
				.setFirstname("Leibniz")
				.setLastname("Berihuete")
				.setUsername("zinbiel")
				.setPassword("piano123")
				.setEmail("Leibniz.Berihuete@gmail.com")
				.setRole(Employee.MANAGER_ROLE);
		new EmployeeImpDao().createEmployee(e);
	}
}

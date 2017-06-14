package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeCompare {

	public static void main(String[] args) {
		ArrayList<Employee> al = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee #1's name: ");
		String name = sc.nextLine();
		System.out.println("Enter Employee #1's Department: ");
		String department = sc.nextLine();
		System.out.println("Enter Employee #1's age: ");
		int age = Integer.parseInt(sc.nextLine());
		Employee firstEmp = new Employee(name,department,age);
		al.add(firstEmp);
		System.out.println("Enter Employee #2's name: ");
		name = sc.nextLine();
		System.out.println("Enter Employee #2's Department: ");
		department = sc.nextLine();
		System.out.println("Enter Employee #2's age: ");
		age = Integer.parseInt(sc.nextLine());
		Employee secondEmp = new Employee(name,department,age);
		al.add(secondEmp);
		
		 System.out.println("Unsorted");
	        for (int i=0; i<al.size(); i++)
	            System.out.println(al.get(i));
	 
	        Collections.sort(al, new SortByName());
	 
	        System.out.println("\nSorted by name");
	        for (int i=0; i<al.size(); i++)
	            System.out.println(al.get(i));
	 
	        Collections.sort(al, new SortByDepartment());
	 
	        System.out.println("\nSorted by Department");
	        for (int i=0; i<al.size(); i++)
	            System.out.println(al.get(i));
	        
	        Collections.sort(al, new SortByAge());
	        System.out.println("\nSorted by age");
	        for (int i=0; i<al.size(); i++)
	            System.out.println(al.get(i));
	        sc.close();
	}

}

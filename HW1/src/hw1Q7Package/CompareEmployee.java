package hw1Q7Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CompareEmployee implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String choice = "";
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee("Kai","IT",30));
		list.add(new Employee("Bin","Marketing",25));


		NameCompare nameCompare = new NameCompare();
		DeptCompare deptCompare = new DeptCompare();
		AgeCompare ageCompare = new AgeCompare();
		
		System.out.println("Enter the following letter: \n n for Name \n d for Department \n a for Age");
		choice = input.nextLine().toLowerCase();
		switch(choice){
			case "n":
				Collections.sort(list,nameCompare);
				break;
			case "d":
				Collections.sort(list,deptCompare);
				break;
			case "a":
				Collections.sort(list,ageCompare);
				break;
			default:
				System.out.println("Wrong input");
				break;

		}
		if(choice.equals("n") || choice.equals("d") || choice.equals("a")){
		System.out.println("movies after sort with Comparator(" + choice + "): ");
			for(Employee e : list){
				System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getAge());
			}
		}
	}
}

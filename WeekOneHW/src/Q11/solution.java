package Q11;

import Q11_a.TwoNumStorage;

public class solution {
	
//	Write a program that would access two float-variables 
//	from a class that exists in another package. Note, 
//	you will need to create two packages to demonstrate the solution.

	public static void main(String[] args) {
		
		System.out.println("From another package: ");
		System.out.println(TwoNumStorage.num1);
		System.out.println(TwoNumStorage.num2);
		
	}
}

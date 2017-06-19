package question6;

import java.util.Scanner;

/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class EvenNoModulus {

	public static void main(String[] args) {
		System.out.println("Enter a number to determine if its even");
		Scanner r = new Scanner(System.in);
		int rand= r.nextInt();
		
		if((rand/2)*2==rand) {
			System.out.println("Yes "+ rand+ " is an Even number");
		}else {
			System.out.println("No, "+ rand+" is an odd number");
		}

	}

}

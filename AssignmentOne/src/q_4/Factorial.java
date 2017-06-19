package q_4;

import java.util.Scanner;

//Write a program to compute N factorial.
public class Factorial {

	public static void main(String[] args) {

		int factorial = 1;
		int number;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter a number and the factorial will be displayed.");
		number = keyboard.nextInt();

		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}

		System.out.println("Factorial of " + number + " is: " + factorial);

		keyboard.close();
	}

}
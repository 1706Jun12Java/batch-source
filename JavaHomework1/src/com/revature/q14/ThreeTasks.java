package com.revature.q14;

import java.text.*;
import java.util.Date;
import java.util.Scanner;

/*
 * Q14. Write a program that demonstrates the switch case. 
 * Implement the following functionalities in the cases:
Case 1: Find the square root of a number using the Math class method. 
Case 2: Display today’s date.
Case 3: Split the following string and store it in a sting array. 
        “I am learning Core Java”
 * 
 */
public class ThreeTasks {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter '1' to find the sqrt of a number");
		System.out.println("Enter '2' to find the currenmt date");
		System.out.println("Enter '3' to split string \"I am learning Core Java\"");
		
		String str ="I am learning Core Java";
		String[] parts;
		
		int scene = scanner.nextInt();
		
		switch (scene){
		case 1:
			System.out.println("Enter a number to find the sqrt of: ");
			double number = scanner.nextDouble();
			System.out.println("the sqrt of "+number+" is: "+Math.sqrt(number));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3:
			parts = str.split(" ");
			for(String s:parts)
				System.out.println(s.toString());
			break;
		default  :
			System.out.println("You didn't enter a vlid choice");
			break;
		
			
		}
	}

}

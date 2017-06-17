package corejava1.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Leibniz Berihuete QUESTION 14: Write a program that demonstrates the
 *         switch case. Implement the following functionalities in the cases:
 * 
 *         Case 1: Find the square root of a number using the Math class method.
 *         Case 2: Display today’s date Case 3: Split the following string and
 *         store it in a string array. “I am learning Core Java”
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("---------------MENU---------------");
		System.out.println("1. Find Square root of a number");
		System.out.println("2. Display today's date");
		System.out.println("3. Split \"I am learning Core Java\"");
		System.out.println("----------------------------------");
		System.out.print("Choose option: ");
		Scanner keyboard = new Scanner(System.in);
		int option = Integer.parseInt(keyboard.nextLine());

		switch (option) {
		case 1:
			// PROMPT FOR NUMBER:
			System.out.print("Enter number:");
			
			// GET SQUARE ROOT RESULT
			double result = Math.sqrt(Double.parseDouble(keyboard.nextLine()));
			System.out.println("square root result= " + result);
			break;
			
		case 2:
			// INDICATE FORMAT
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			
			// GET DATE AND PRINT WITH THE FORMAT INDICATED ABOVE.
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			
			break;
			
		case 3:
			// USING THE STRING METHOD: split()
			String message = "I am learning core Java";
			String [] array = message.split(" ");
			System.out.println(Arrays.toString(array));
			break;
		default:
			System.exit(0);

		}
	}
}

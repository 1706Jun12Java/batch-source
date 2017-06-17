package corejava1.q17;

import java.util.Scanner;

/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 17:
 *      Write a program that calculates the simple interest
 *      on the principal, rate of interest and number of years
 *      provided by the user. Enter principal, rate and time 
 *      through the console using the Scanner class.
 *      
 *      Interest = Principal* Rate* Time
 */
public class Main17 {
	public static void main(String [] args) {
		// Create a scanner to obtain keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		// Prompt principle
		System.out.print("Enter principle: ");
		double principal = Double.parseDouble(keyboard.nextLine());
		
		// Prompt rate
		System.out.print("Enter rate: ");
		double rate = Double.parseDouble(keyboard.nextLine());
		
		// Prompt time
		System.out.print("Enter time: ");
		double time = Double.parseDouble(keyboard.nextLine());
		
		// Calculate interest
		double interest = principal * rate * time;
		
		System.out.println("Interest: " + interest);
		
	}
}

package q17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Write a program that calculates the simple interest on the principal, 
		rate of interest and number of years provided by the user. 
		Enter principal, rate and time through the console using the Scanner class.
		Interest = Principal* Rate* Time*/
		
		Scanner sc = new Scanner(System.in);
		double interest, principal,rate;
		int time; // time is calculated in years 
		
		System.out.println("*******Simple Interest Calculator*********");
		System.out.println("Principal: ");
		principal = sc.nextDouble();
		System.out.println("Rate: ");
		rate = sc.nextDouble();
		System.out.println("Time (in years): ");
		time = sc.nextInt(); 
		
		interest = principal * rate * time; 
		System.out.println("Your interest payment is: $" + interest);
		
		sc.close();

	}

}

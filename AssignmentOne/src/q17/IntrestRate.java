package q17;

import java.util.Scanner;

//Write a program that calculates 
//the simple interest on the principal,
//rate of interest and number of years
//provided by the user. Enter principal, 
//rate and time through the console using the Scanner class.
//Interest = Principal* Rate* Time
public class IntrestRate {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter principal:");
		int Principal = keyboard.nextInt();
		System.out.println("Enter rate of interest:");
		int Rate = keyboard.nextInt();
		System.out.println("Enter number of years:");
		int Time = keyboard.nextInt();
		int Intrest = Principal * Rate * Time;
		System.out.println("Your intrest will be: " + Intrest);
		keyboard.close();
	}
}
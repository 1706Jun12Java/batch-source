package com.revature.q17;

import java.util.Scanner;

/*
 * 
 * Write a program that calculates the simple interest on the 
 * principal, rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time

 * 
 */
public class SimpleInterest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double principal, rate;
		System.out.println("Please enter the principal amount:");
		principal = scan.nextDouble();
		System.out.println("Please enter the rate of interest:");
		rate = scan.nextDouble();
		rate/=100;
		double interest = principal*rate;
		double roundedInterest=interest*100;
		roundedInterest = Math.round(interest);
		roundedInterest/=100;
		System.out.println("Interest is: $"+roundedInterest);
		
	}

}

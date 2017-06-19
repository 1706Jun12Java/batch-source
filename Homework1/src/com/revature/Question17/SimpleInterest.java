package com.revature.Question17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		Float p,r,t;
		Scanner sc = new Scanner(System.in);
		System.out.println("Simple Interest Calculator: \n\nBefore we begin we need some information: \nEnter the Principal Amount: ");
		p = sc.nextFloat();
		System.out.println("\nPrincipal: $" + p + " \nEnter the Interest Rate: ");
		r= sc.nextFloat();
		System.out.println("\nPrincipal: $" + p + " \nInterest Rate: " + r + "%"+ "\nEnter the How many Years have Elapsed: ");
		t=sc.nextFloat();
		System.out.println("\nPrincipal: $" + p + " \nInterest Rate: " + r + "%"+ "\nEnter the How many Years have Elapsed: "+ t +" years");
		
		float interest = (p*r*t)/100;
		System.out.println("Interest gained: $" + interest);
		
	}

}

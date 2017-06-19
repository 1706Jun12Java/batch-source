package hw1Q17Package;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		double principal,interest;
		int rate,tTime;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your principal");
		principal = input.nextDouble();
		System.out.println("Enter your rate");
		rate = input.nextInt();
		System.out.println("Enter your time");
		tTime = input.nextInt();
		
		System.out.println("Interest: " + (principal * rate * tTime));
	}

}

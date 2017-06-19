package Question17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		//declare variables needed
		double principle, rate;
		int time;
		//create scanner object that takes in user input
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Simple Interest Calculator");
		System.out.println("Enter your principle amount");
		principle = sc1.nextDouble();
		System.out.println("Enter your rate. Make sure to convert your percentage to decimal form (i.e 5% = .05)");
		rate = sc1.nextDouble();
		System.out.println("Enter time (in years)");
		time = sc1.nextInt();
		System.out.println("Calculating.......");
		//print out interest by itself
		System.out.println("Interest accrued is: $"+principle*rate*time);
		//print out simple interest using formula : P*(1+rt), which is total amount after interest is applied
		System.out.println("Your total accrued amount with your interest is: $"+ principle*(1+rate*time));
		sc1.close();


		
	}
}

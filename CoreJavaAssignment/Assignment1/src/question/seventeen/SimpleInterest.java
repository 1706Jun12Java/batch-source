package question.seventeen;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		float principal, rate, years, interest;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal: ");
		principal = sc.nextFloat();
		
		System.out.println("Enter the rate: ");
		rate = sc.nextFloat();

		System.out.println("Enter the years: ");
		years = sc.nextFloat();
		
		sc.close();
		
		interest = principal*rate*years;
		
		System.out.println("Your simple interest is: " + interest);

	}

}

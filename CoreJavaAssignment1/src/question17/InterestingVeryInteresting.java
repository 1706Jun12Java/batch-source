package question17;

import java.util.Scanner;

public class InterestingVeryInteresting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal amount: ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the rate: ");
		double b = Double.parseDouble(sc.nextLine());
		System.out.println("Enter the amount of time in years: ");
		int c = Integer.parseInt(sc.nextLine());
		double interest =  a*b*c;
		System.out.println("Your interest is " + interest);
		sc.close();
	}

}

package Question17;

import java.util.*;

public class Question17 {
	public static void main(String[] args) {
		// Intialize scan
		Scanner scan = new Scanner(System.in);
		// Get the principle from the user
		System.out.println("Insert Principle");
		double principal = scan.nextDouble();
		// Get the rate from the user
		System.out.println("Insert Rate");
		double rate = scan.nextDouble();
		// Get the time from the user
		System.out.println("Insert Time");
		double time = scan.nextDouble();
		// print the result
		double interest = time * rate * principal;
		System.out.println("The Interest is " + interest);
	}
}

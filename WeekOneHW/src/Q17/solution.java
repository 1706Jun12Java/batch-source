package Q17;

import java.util.*;

public class solution {

	// Write a program that calculates the simple interest on the principal,
	// rate of interest and number of years provided by the user. Enter
	// principal, rate and time through the console using the Scanner class.
	// Interest = Principal* Rate* Time

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter principal:  ");
			float principal = Float.parseFloat(sc.nextLine());

			System.out.print("Enter rate:  ");
			float rate = Float.parseFloat(sc.nextLine());

			System.out.print("Enter time in years:  ");
			float time = Float.parseFloat(sc.nextLine());

			System.out.print("Interest:  " + principal * rate * time);
		}
	}

}

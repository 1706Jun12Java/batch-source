package question17;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner abc = new Scanner(System.in);
		System.out.println("Please enter the principal?");
		double principal = abc.nextDouble();
		System.out.println("Please enter the rate from 0 to 1 in decimal?");
		double rate = abc.nextDouble();
		System.out.println("Please enter the time in years?");
		double time = abc.nextDouble();
		
		double interest = principal*rate*time;
		System.out.println("The intrest for loan be " + interest);
		

	}

}

package Question17;

import java.util.Scanner; 

public class SimpleInterest {

	public static void main(String[] args) {

		double interest;
		double princip;
		double rate;
		double numYears;
		
		Scanner scan= new Scanner(System.in);
		
		System.out.println("please enter the principal followed by the rate and number of years");
		
		princip= scan.nextDouble(); 
		rate= scan.nextDouble();
		numYears=scan.nextInt(); 
		
		interest = princip*rate*numYears; 
		
		System.out.println("your interest is " +interest);
		
		
		
		
	}

}

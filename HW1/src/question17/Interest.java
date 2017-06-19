package question17;
import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		Scanner num1 = new Scanner(System.in);
		System.out.println("Enter the principal value");
		double principal = num1.nextDouble();

		System.out.println("Enter the rate value");
		double rate = num1.nextDouble();
		
		System.out.println("Enter the time value");
		int time = num1.nextInt();
		
		double interest = principal*rate*time;
		System.out.println("The total interest is " + interest);
	}

}

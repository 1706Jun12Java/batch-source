package question4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Enter a number to find its factorial:");
		
		int ans = 1;
		
		Scanner n = new Scanner(System.in);
		int fnum = n.nextInt();
		
		if( fnum < 0){
			System.out.println("Please enter a positive number");
		} else {
			for(int i =1; i<= fnum; i++ )
				ans = ans*i;
			System.out.println("The factorial of "+ fnum + " is "+ ans);
		}
		}
}

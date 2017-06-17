package q4;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Write a program to compute N factorial. (n!)
		Scanner sc = new Scanner(System.in);
		System.out.println("Number: ");
		int n = sc.nextInt(); 
		
		int factorial = 1; 
		
		for(int i=1;i<=n;i++){
			factorial = factorial * i; 
		}
		
		System.out.println("Factorial of " + n + " is " + factorial);
		sc.close();


	}

}



package question10;

import java.util.Scanner;

public class MinNumber {
	
	public static void main(String[] args){
		System.out.println("Enter first number: ");
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("Enter second number: ");
		int b = Integer.parseInt(sc.nextLine());
		int c = (a < b) ? a:b;
		System.out.println("The smaller number is: " + c);
		sc.close();
	}
}

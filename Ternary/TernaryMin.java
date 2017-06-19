/*
 * Find the minimum of two numbers using ternary operators.
 */
package Ternary;
//import java.util.Scanner;

public class TernaryMin {
	
	public static void main(String[] args) {
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int a = scanner.nextInt();
		System.out.println("Enter another number: ");
		int b = scanner.nextInt();
		*/
		
		int a = 16;
		int b = 17;
		float min = (float) a < b ? a : b;
		System.out.println(min);
	}
}

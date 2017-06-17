package q16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Write a program to display the number of characters for a string input. 
		The string should be entered as a command line argument using (String [ ] args).*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String input = sc.nextLine(); 
		char[] a = input.toCharArray();
		
		int count =0; 
		for (@SuppressWarnings("unused") char c : a){
			count++;
		}
		System.out.println("The number of characters for this string input is: " + count);
		
		sc.close();

	}

}

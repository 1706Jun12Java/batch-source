package q5;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.
		/*
		 * Convert a string into a character array. 
		 * Give an integer index. 
		 * Print through a for loop character up until that index (-1 because array indices start at 0) 
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("String: ");
		String str = sc.nextLine(); 
		
		System.out.println("Index Number: ");
		int n = sc.nextInt(); 
		
		char[] ch = str.toCharArray(); 
		
		for(int i =0; i<=(n-1); i++)
		{
			System.out.println(ch[i]);
		}
		
		sc.close();
		

	}

}


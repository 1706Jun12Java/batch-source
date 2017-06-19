package q_3;

import java.util.Scanner;

//Reverse a string without using a temporary variable.  
//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
public class Reverse {

	public static void main(String[] args) {
		
		//creates a scanner to take in user input via keyboard. 
		Scanner keyboard = new Scanner(System.in);
		String word;

		System.out.println("Type a string and the reverse will be printed.");
		word = keyboard.nextLine();//user input is saved in 'word'.
		
		System.out.println("\nThe string you typed is: " + word + "\n");
		System.out.println("The reverse of your string is: ");
		
		for (int i = word.length() - 1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
		keyboard.close();
	}
}
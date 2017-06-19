package question3;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word to reverse:\n");
		String userInput = scanner.nextLine();
		for (int i = 0; i < userInput.length(); i++) {
			userInput = userInput.substring(1, userInput.length() - i) + userInput.substring(0, 1) + userInput.substring(userInput.length() - i, userInput.length());
		    
		 }
		System.out.println("Your word reversed looks like this: " + userInput);
		scanner.close();
	}
}
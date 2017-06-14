package question3;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word:\n");
		String uInput = sc.nextLine();
		for (int i = 0; i < uInput.length(); i++) {
			System.out.println("Before step "+ i+ ":" +uInput);
		    uInput = uInput.substring(1, uInput.length() - i) + uInput.substring(0, 1) + uInput.substring(uInput.length() - i, uInput.length());
		    System.out.println("After:step "+ i+ ":"  +uInput);
		 }
		System.out.println("Here is your word reversed: " + uInput);
		sc.close();
	}
}

package corejava1.q08;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 8:
 *	Write a program that stores the following strings in an ArrayList and saves all the
 *  palindromes in another ArrayList. 
 *  “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
 */
public class Palindrome {
	
	
	// Checks whether the str is a palindrome
	public static boolean isPali(String str) {
		String reversedString = "";
		for(int i = str.length()-1; i >= 0; i--) {
			reversedString += str.charAt(i);
		}		
		return reversedString.equals(str);
	}
	
	// MAIN
	public static void main(String [] args) {
		String [] strArray = {
				"karan", "madam", "tom", "civic", "radar", 
				"jimmy", "kayak", "john", "refer", "billy", 
				"did"
		};
		
		// Add it to arrayList
		ArrayList<String> allStrings = new ArrayList<>(Arrays.asList(strArray));
		
		// This will hold the palindromes
		ArrayList<String> paliStrings = new ArrayList<>();
		
		for(int i = 0; i < allStrings.size(); i++) {
			
			// isPali returns whether is palindrome or not
			if(isPali(allStrings.get(i))) {
				paliStrings.add(allStrings.get(i));
				System.out.println(allStrings.get(i));
			}
			
		}		
		
	}
	
}

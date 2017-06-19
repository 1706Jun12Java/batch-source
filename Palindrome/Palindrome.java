/*
 * Write a program that stores the following strings in an ArrayList and 
 * saves all the palindromes in another ArrayList. 
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
 */
package Palindrome;
import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		//create and populate an ArrayList
		ArrayList<String> words = new ArrayList<>();
		words.addAll(Arrays.asList("karan","madam","tom","civic","radar","jimmy","kayak","john","refer","billy","did"));
		
		System.out.println(words); 
		System.out.println(palind(words)); //
	}
	// method to store palindromes to a new ArrayList
	public static ArrayList<String> palind(ArrayList<String> w){
	    int count = 0;
	    ArrayList<String> palindromes = new ArrayList<>();
	    //iterate through the ArrayList
	    for(String s : w){
	            if(isPalindrome(s)){ //call isPalindrom, if true, add to new ArrayList
	                count++;
	                palindromes.add(s);
	            }
	        }
	    return palindromes;
	}
	//method to check if a string in ArrayList is palindrome
	public static boolean isPalindrome(String str) {    
	    int n = str.length();
	    for( int i = 0; i < n/2; i++ )
	    	//compare characters of a string at each end until the middle char
	        if (str.charAt(i) != str.charAt(n-i-1)) return false; // if characters are not same
	    return true;    
	}
}

package q_8;

import java.util.ArrayList;

//Write a program that stores the following strings 
//in an ArrayList and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, 
//“kayak”, “john”,  “refer”, “billy”, “did”
public class Palindromes {

	public static void main(String[] args) {

		// creating 2 arraylist.
		ArrayList<String> randomWords = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();

		// adding strings into the arraylist.
		randomWords.add("karan");
		randomWords.add("madam");
		randomWords.add("tom");
		randomWords.add("civic");
		randomWords.add("radar");
		randomWords.add("jimmy");
		randomWords.add("kayak");
		randomWords.add("john");
		randomWords.add("refer");
		randomWords.add("billy");
		randomWords.add("did");

		// printing whats in arraylist 'randomWords'
		System.out.println("List of random words\n");
		for (int i = 0; i < randomWords.size(); i++) {
			System.out.println(randomWords.get(i));
		}

		// go through randomWors arraylist and reverse each word.
		// if the reverse equals the orginal randomword then it
		// is a palindrome and is added to the palindrome arraylist.
		for (int i = 0; i < randomWords.size(); i++) {
			StringBuffer reverseWord = new StringBuffer(randomWords.get(i));
			reverseWord = reverseWord.reverse();
			String palindromeWord = reverseWord.toString();
			if (randomWords.get(i).equals(palindromeWord)) {
				palindromes.add(randomWords.get(i));
			}
		}

		System.out.println("\nList of Palindromes\n");
		for (int i = 0; i < palindromes.size(); i++)
			System.out.println(palindromes.get(i));
	}

}

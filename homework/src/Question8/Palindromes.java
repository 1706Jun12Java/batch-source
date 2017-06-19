package Question8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {

		//create String that holds words and ArrayLists that will hold the words
		String[] words = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did" };
		ArrayList<String> palindromes = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		
		//create for loop to add all words to one list and the palindromes to another
		for (String i : words){
			list.add(i);
			if (isPalindrome(i)){
				palindromes.add(i);
			}
		}
		System.out.println(palindromes);
		System.out.println(list);

	}

	//test for palindrome
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}

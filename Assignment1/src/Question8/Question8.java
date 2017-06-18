package Question8;

import java.util.*;

public class Question8 {
	public static void main(String[] args) {
		// Initialize a string arrays
		// assign values to strArr
		String[] strArr = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did" };
		ArrayList<String> palindrome = new ArrayList<>();
		ArrayList<String> notAPalindrome = new ArrayList<>();
		boolean isPalidrome = true;
		// check each string to see if its a palidrome
		for (String s : strArr) {
			isPalidrome = true;
			// check the current char to char on the other side
			// ex: "Kayak" compare strArr[1] to strArr[3]
			for (char c : s.toCharArray()) {
				if (c != s.charAt(s.length() - s.indexOf(c) - 1))
					isPalidrome = false;
			}
			// if a palidrome is found, add it to palindrome list
			// otherwise add to notPalindrome list
			if (isPalidrome)
				palindrome.add(s);
			else
				notAPalindrome.add(s);
		}
		// print final lists
		System.out.println(palindrome);
		System.out.println(notAPalindrome);
	}
}

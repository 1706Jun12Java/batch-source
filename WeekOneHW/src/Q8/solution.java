package Q8;

import java.util.ArrayList;

public class solution {

//	Write a program that stores the following strings in an ArrayList and saves all the
//	palindromes in another ArrayList.
//	“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”

 
	
	public static void main(String[] args) {
		 String[] StringList = {
				 "karan", "madam", "tom", "civic", 
				 "radar", "jimmy", "kayak", "john", 
				 "refer", "billy", "did"
				};
		 
		 ArrayList<String> PalindromeList = new ArrayList<String>(); 
		 
		 for (String word : StringList){
			 if (checkPalindrome(word)) {
				 PalindromeList.add(word);
			 }
		 }
		 
		 System.out.println("The palindrome: ");
		 for (String word: PalindromeList){
			 System.out.println(word);
		 }
		 
	}

	static boolean checkPalindrome(String word){
		
		if (word.length() <= 1){
			return true;
		}
		for (int i=0; i<word.length()/2;i++){
			if ( word.charAt(i) != word.charAt(word.length()-i-1)){
				return false;
			}
		}
		return true;
	}
}

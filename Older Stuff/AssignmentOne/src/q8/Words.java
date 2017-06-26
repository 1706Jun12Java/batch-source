package q8;

import java.util.ArrayList;

public class Words {
	
	public static void main(String[] args){
		/*Write a program that stores the following strings in an ArrayList and saves 
		all the palindromes in another ArrayList.
		“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”*/
		ArrayList<String> w = new ArrayList<String>();
		w.add("karan");
		w.add("madam");
		w.add("tom");
		w.add("civic");
		w.add("radar");
		w.add("jimmy");
		w.add("kayak");
		w.add("john");
		w.add("refer");
		w.add("billy");
		w.add("did");
		
		System.out.println("Original List: ");
		for (String s: w){
			System.out.print(s + " - ");
		}
		
		System.out.println("");
		
		System.out.println("");
		
		System.out.println("Palindrome List: ");
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		for (String s: w){
			if(checkPalindrome(s)== true){
				palindromeList.add(s);
			}
		}
		
		for (String s: palindromeList){
			System.out.print(s + " - ");
		}
		
	}
	
	
	public static boolean checkPalindrome (String word){
		int i1 = 0;
	    int i2 = word.length() - 1;
	    while (i2 > i1) {
	        if (word.charAt(i1) != word.charAt(i2)) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
		return true;
	}

}

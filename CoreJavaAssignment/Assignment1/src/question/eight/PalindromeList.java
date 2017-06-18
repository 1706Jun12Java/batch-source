package question.eight;

import java.util.ArrayList;

public class PalindromeList {

	public static void main(String[] args) {
		ArrayList<String> myArrayList = new ArrayList<>();
		myArrayList.add("karan");
		myArrayList.add("madam");
		myArrayList.add("tom");
		myArrayList.add("civic");
		myArrayList.add("radar");
		myArrayList.add("jimmy");
		myArrayList.add("kayak");
		myArrayList.add("john");
		myArrayList.add("refer");
		myArrayList.add("billy");
		myArrayList.add("did");
		
		System.out.println("myArrayList: " + myArrayList);
		
		ArrayList<String> myPalindromes = new ArrayList<>();
		for (String s: myArrayList){
			if (isPalindrome(s)){
				myPalindromes.add(s);
			}
		}
		
		System.out.println("myPalindromes: " + myPalindromes);
	}
	
	public static boolean isPalindrome(String s) {
		int n = s.length();
		for (int i=0; i<(n/2); i++){
			if (s.charAt(i)!=s.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}

}

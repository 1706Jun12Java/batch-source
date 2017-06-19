package ReverseString;

import java.util.Scanner;

public class Reverse_String {

	public static void main(String[] args) {
	    // 
		System.out.println("Write something: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String result="";
	    for (int i=input.length()-1; i>=0; i--) {
	        result = result + input.charAt(i);
	    }
	    System.out.println("Reversed entry is: " + result);
	
	}
}

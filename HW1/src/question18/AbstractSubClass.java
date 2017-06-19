package question18;

import java.util.*;

public class AbstractSubClass extends AbstractBase {
	/**
	 * Checks a string for any uppercase characters
	 */
	@Override
	public boolean hasUpperCase(String str) {
		
		String str2 = str.toLowerCase();
		// If str and str2 are stored differently in the stringpool, that means
		// str had an uppercase character
		if (str2 != str)
			return true;
		
		return false;
	}

	
	@Override
	public String toUpperCase() {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.toUpperCase();
		return str;
	}

	/**
	 * stores a user inputted string into an int and add 10 then print the
	 * result
	 */
	@Override
	public void toIntPlus10() {
		// take user input
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		// convert to int and add 10
		int num = Integer.valueOf(str) + 10;
	
		System.out.println(num);
	}

}

   

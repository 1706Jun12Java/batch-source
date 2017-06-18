package Question18;

import java.util.*;

public class SubClass extends AbstractBaseClass {
	/**
	 * Checks a string for any uppercase characters
	 */
	@Override
	public boolean hasUpperCase(String str) {
		// create a string with the same values after a toLowerCase() call
		String str2 = str.toLowerCase();
		// If str and str2 are stored differently in the stringpool, that means
		// str had an uppercase character
		if (str2 != str)
			return true;
		return false;
	}

	/**
	 * converts a user input into uppercase
	 */
	@Override
	public String toUpperCase() {
		// take user input
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.toUpperCase();
		return str;
	}

	/**
	 * converts a user inputted string into an int and add 10 then print the
	 * result
	 */
	@Override
	public void toIntPlus10() {
		// take user input
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		// convert to int and add 10
		int num = Integer.valueOf(str) + 10;
		// print result
		System.out.println(num);
	}

}

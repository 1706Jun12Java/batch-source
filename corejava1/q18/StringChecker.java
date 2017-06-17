package corejava1.q18;
/**
 * 
 * @author Leibniz Berihuete
 * StringChecker Overrides three methods:
 * 1. containsUppercase()
 * 2. convertAllToUppercase()
 * 3. convertToIntegerPlus10()
 * 
 * 1 - returns a boolean if any uppercase character is found
 * 2 - returns a new string by converting all lowercase letter to uppercase.
 * 3 - converts a string to integer, then it adds 10, and print out the result
 */
public class StringChecker extends StringBasicCheck{

	@Override
	public boolean containsUppercase(String string) {
		for(int i = 0; i < string.length(); i++) {
			// Get the letter
			String letter = string.charAt(i) + "";
			
			// Compare the letter to the lower case version
			if(letter != letter.toLowerCase()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertAllToUppercase(String string) {
		return string.toUpperCase();
	}

	@Override
	public void convertToIntegerPlus10(String string) {
		// convert to integer then add 10
		int num = Integer.parseInt(string) + 10;
		
		// Print result
		System.out.println("convertToIntegerPlus10() returns: " + num);
	}
	
}

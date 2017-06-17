package corejava1.q05;
/**
 * @author Leibniz Berihuete
 * QUESTION 5:
 * Write a substring method that accepts a string str and an integer idx and returns the
 * substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
 * substring methods in the String, StringBuilder, or StringBuffer APIs.
 */
public class SubstringMethod {
	public static String originalSubstring(String str, int index) {
		String substring = "";
		
		// Check whether the indicated index is possible or not.
		if(str.length() - 1 < index) {
			System.out.println("ERROR: index does not exist in the string");
			System.exit(0);
		}
		else {
			
			// Keeps adding the characters until reaches the designated index
			for(int i = 0; i < index; i++) {
				substring += str.charAt(i);
			}
			
		}
		return substring;
	}
	
	public static void main(String [] args) {
		String message = "Hello World";
		System.out.println(originalSubstring(message, 6));
	}
}

package corejava1.q18;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 18:
 *     Write a program having a concrete subclass that inherits three
 *     abstract methods from a superclass. Provide the following three
 *     implementations in the subclass corresponding to the abstract 
 *     methods in the superclass:
 *     
 *     1. Check for uppercase characters in a string, and return �true�
 *        or �false� depending if any are found.
 *     
 *     2. Convert all of the lower case characters to uppercase in the 
 *        input string, and return the result.
 *        
 *     3. Convert the input string to integer and add 10, output the 
 *        result to the console.
 *        
 *     Create an appropriate class having a main method to test the 
 *     above setup.
 */
public class Main18 {
	public static void main(String [] args) {
		String message = "Hello World";
		
		StringChecker strChecker = new StringChecker();
		
		boolean boolResult = strChecker.containsUppercase(message);
		System.out.println("containsUppercase() returns: " + boolResult);
		
		String strResult = strChecker.convertAllToUppercase(message);
		System.out.println("convertAllToUppercase() returns: " + strResult);
		
		strChecker.convertToIntegerPlus10("15");
		
	}
	
}

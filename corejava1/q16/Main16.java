package corejava1.q16;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 16:
 *   Write a program to display the number of characters
 *   for a string input. The string should be entered as 
 *   a command line argument using (String [ ] args).
 */
public class Main16 {
	public static void main(String [] args) {
		System.out.println("The number of characters for " + args[0] + 
				           " is: " + args[0].length());
	}
}

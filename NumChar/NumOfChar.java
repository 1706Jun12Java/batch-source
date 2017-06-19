/*
 * Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).
 */
package NumChar;

public class NumOfChar {

	public static void main(String[] args) {  
		
		String str = args[0];
		int count = 0;
		for (int i = 0; i<str.length(); i++){
			count += 1;
		}
	}
}

package corejava1.q03;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 3:
 *     Reverse a string without using a temporary variable. 
 *     Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class ReverseString {
	
	public static String reverseStr(String str) {
		String newStr = ""; // this is not a temp, since it will be the actual return.
		for(int i = str.length()-1; i >=0 ; i--) {
			newStr+= str.charAt(i);
		}
		return newStr;
	}
	
	public static void main(String [] args) {
		System.out.println(reverseStr("Leibniz"));
	}
}

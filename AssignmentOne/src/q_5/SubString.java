package q_5;

//Write a substring method that accepts a string str and an integer idx
//and returns the substring contained between 0 and idx-1 inclusive. 
//Do NOT use any of the existing
//substring methods in the String, StringBuilder, or StringBuffer APIs.
public class SubString {

	public static void main(String[] args) {

		String s = "HelloWorld";
		int x = 5;
		System.out.println(sub(s, x));

	}

	public static String sub(String str, int idx) {
		
		String subString = "";
		
		//Takes 'str' and puts in each letter
		//into substring up until idx-1.
		for (int i = 0; i < idx; i++) {
			subString += str.charAt(i);
		}
		return subString;
	}
}
package Q3;

public class Solution {

//	Reverse a string without using a temporary variable. Do NOT use reverse() in the
//	StringBuffer or the StringBuilder APIs.
	
	public static void main(String[] args) {
		 
//string is immutable, so has to create a new string
		
		String s = "live";
		
		StringBuffer s_reverse = new StringBuffer();
		
		for (int i = s.length()-1; i >= 0; i--){
			s_reverse.append(s.charAt(i));
		}

		System.out.println(s);
		System.out.println(s_reverse);
	}

}

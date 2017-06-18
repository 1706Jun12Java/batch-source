package Question5;

public class Question5 {

	public static void main(String[] args) {
		String s = "This is a string";
		System.out.print(subString2(s, 10));
	}

	/**
	 * return a substring to a cartain index
	 */
	public static String subString2(String str, int num) {
		String str2 = "";
		// we add all values from 0 to num to a temporary string
		for (int x = 0; x < num; x++)
			str2 = str2 + str.charAt(x);
		// return the temporary string
		return str2;
	}

}

package Question3;

public class Question3 {

	public static void main(String[] args) {
		String str = "1234567890";
		str = reverseString(str);
		System.out.println(str);
	}

	public static String reverseString(String str) {
		// convert str to a charArray
		for (char c : str.toCharArray()) {
			// add the char to the beginning of str
			str = c + str;
			// remove the last char
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

}

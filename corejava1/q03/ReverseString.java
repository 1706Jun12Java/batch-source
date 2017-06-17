package corejava1.q03;

public class ReverseString {
	
	public static String reverseStr(String str) {
		String newStr = "";
		for(int i = str.length()-1; i >=0 ; i--) {
			newStr+= str.charAt(i);
		}
		return newStr;
	}
	
	public static void main(String [] args) {
		System.out.println(reverseStr("Leibniz"));
	}
}

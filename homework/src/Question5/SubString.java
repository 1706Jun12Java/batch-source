package Question5;

public class SubString {

	//create method that gives substring of a string at index idx-1
	public static String subString(String str, int idx){
		String str2 = "";
		//use for loop to go through the index of your string
		for (int i=0; i<idx;i++){
			str2 = str2 + str.charAt(i);
		}
		return str2;
	}
	public static void main(String[] args) {
		
		System.out.println(subString("Hello Everyone",7));
		
	}
}

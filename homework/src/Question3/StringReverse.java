package Question3;

public class StringReverse {

	public static void main(String[] args) {
		
		String str = "hello";
		char[] c = str.toCharArray();
		for (int i = c.length -1; i>=0;i--){
			System.out.print(c[i]);
		}
		
	}
	


}

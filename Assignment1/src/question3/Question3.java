package question3;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String code = "Hello World";
		int num =code.length();
		//System.out.println(code.length()); 
		
		

		for(int i=0; i<code.length(); i++) {
			System.out.print(code.charAt(num-1));
			num =num-1;
		}
	}

}

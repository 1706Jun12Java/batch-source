package question.five;

public class SubString {

	public static void main(String[] args) {
		getSubString("helloeveryone", 5);

	}
	
	public static void getSubString(String s, int n){
		for (int i=0; i<n; i++){
			System.out.print(s.charAt(i));
		}		
		
	}

}

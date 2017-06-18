package question.three;

public class Reverse {

	public static void main(String[] args) {
		reverseThis("hello nana");

	}
	
	public static void reverseThis(String args){
		int n = args.length();
		for(int i=n-1; i>=0; i--){
			System.out.print(args.charAt(i));
		}
		
		
	}

}
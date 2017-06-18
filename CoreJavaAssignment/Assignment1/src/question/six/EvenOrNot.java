package question.six;

public class EvenOrNot {
	static boolean isa;

	public static void main(String[] args) {
		int num = 10;
		System.out.println(evenOrNot(num));		
	}
	
	public static boolean evenOrNot(int n){
		if ((n/2)*2 == n){
			return true;
		}
		else {
			return false;
		}
		
	}

}

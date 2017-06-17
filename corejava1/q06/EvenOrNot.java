package corejava1.q06;

/*
 * Write a program to determine if an integer is even without using the modulus
 * operator (%)
 */

public class EvenOrNot {
	public static boolean isEven(int num) {
		boolean even = true;
		
		double doubleResult = num / 2.0;
		
		int intResult = num / 2;
		
		if(intResult < doubleResult) {
			even = false;
		}
		
		return even;
	}
	
	public static void main(String [] args) {
		System.out.println("1 is even? " + isEven(1));
		System.out.println("3 is even? " + isEven(3));
		System.out.println("4 is even? " + isEven(4));
		System.out.println("8 is even? " + isEven(8));
		System.out.println("79 is even? " + isEven(79));
		System.out.println("82 is even? " + isEven(82));
	}
}

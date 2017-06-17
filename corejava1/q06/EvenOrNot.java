package corejava1.q06;

/**
 * @author Leibniz Berihuete
 * QUESTION 6:
 * Write a program to determine if an integer is even without using the modulus
 * operator (%)
 */

public class EvenOrNot {
	public static boolean isEven(int num) {
		boolean even = true;
		
		// let's do a double result
		double doubleResult = num / 2.0;
		
		// lets do an integer result
		int intResult = num / 2;
		
		// compare both
		if(intResult < doubleResult) {
			
			even = false;
			
			/* **************************************************************
			 * NOTE: THIS IS HOW IT WORKS:
			 * 
			 *  NOT EVEN EXAMPLE:
			 *    doubleResult = 13 / 2.0 = 6.5
			 *    intResult = 13 / 2 = 6;
			 *  
			 *    if(6 < 6.5) then even = false:
			 *  
			 *  EVEN EXAMPLE:
			 *    doubleResult = 12 / 2.0 = 6.0;
			 *    intResult = 12 / 2 = 6;
			 *  
			 *    if(6 < 6.0) --- condition don't pass therefore, even = true
			 *  
			 * ***************************************************************/
			
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

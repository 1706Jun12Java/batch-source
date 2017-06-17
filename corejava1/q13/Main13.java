package corejava1.q13;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 13Display the triangle on the console as 
 * follows using any type of loop. Do NOT use 
 * a simple group of print statements to accomplish this.
 *
 *  0
 *
 *  1 0
 *
 *  1 0 1
 *
 *  0 1 0 1
 *   
 *
 */
public class Main13 {
	public static int bit = 1;
	
	
	// int count holds how many times bit will be printed in a single line
	public static void printBits(int count) {
		String strBits = "";
		
		for(int i = 0; i < count; i++) {
			// In order to change bit from 0 to 1
			if(bit == 0) {
				bit = 1;
			}
			else {
				bit = 0;
			}
			
			strBits += bit +" ";			
		}
		
		System.out.println(strBits);
	}
	
	public static void main(String [] args) {
		// prints triangle
		for(int i = 0; i < 5; i++) {
			printBits(i+1);
		}
	}
	
}

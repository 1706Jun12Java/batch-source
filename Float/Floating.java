/*
 * Write a program that would access two float-variables from a class that exists in
another package. Note, you will need to create two packages to demonstrate the
solution.
 */
package Float;
import Ternary.TernaryMin;

// NOT COMPLETE!!!

public class Floating {

	public static void main(String[] args) {
		
		TernaryMin class1 = new TernaryMin();
		
		float result;
		float a = (float) 6.8;
		result = a + class1.min;
		System.out.println(result);
	}

}

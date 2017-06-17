package corejava1.q10;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 10:
 *	Find the minimum of two numbers using ternary operators.
 */
public class TernaryAndMinimum {
	
	public static int getMin(int a, int b) {
		return (a <= b) ? a : b;
	}
	
	public static void main(String [] args) {
		System.out.println("Minimum[11, 9]: " + getMin(11, 9));
		System.out.println("Minimum[5, 8]: " + getMin(5, 8));
		System.out.println("Minimum[3, 4]: " + getMin(3, 9));
		
	}
}

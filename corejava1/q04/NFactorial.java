package corejava1.q04;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 4:
 *     Write a program to compute N factorial.
 */
public class NFactorial {
	
	// RECURSIVE WORK BEST FOR THIS PROBLEM
	public static int nFac(int num) {
		// Here we have to return something other wise it will run forever.
		if(num == 1) {
			return 1;
		}
		int answer = nFac(num - 1) * num;
		return answer;
	}
	
	public static void main(String [] args) {
		System.out.println(nFac(3));
	}
}

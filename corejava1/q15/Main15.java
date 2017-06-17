package corejava1.q15;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 15
 * 	Write a program that defines an interface having 
 * 	the following methods: addition, subtraction, 
 * 	multiplication, and division. Create a class that
 * 	implements this interface and provides appropriate 
 * 	functionality to carry out the required operations. 
 * 	Hard code two operands in a test class having a main 
 * 	method that calls the implementing class.
 */
public class Main15 {
	public static void main(String [] args) {
		double operand1 = 15.0;
		double operand2 = 3.0;
		
		BasicMath basicMath = new BasicMath();
		System.out.println("Operand1: " + operand1 + "\nOperand2: " + operand2 +"\n\n");
		System.out.println("ADDITION: " + basicMath.addition(operand1, operand2));
		System.out.println("SUBTRACTION: " + basicMath.subtraction(operand1, operand2));
		System.out.println("MULTIPLICATION: " + basicMath.multiplication(operand1, operand2));
		System.out.println("DIVISION: " + basicMath.division(operand1, operand2));
	}
}

/*
 * Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division. Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations. Hard code
 * two operands in a test class having a main method that calls the implementing class.
 */
package Interface;

public class MainClass {

	public static void main(String[] args) {
		InterfaceClasses obj = new InterfaceClasses();
		System.out.println(obj.add(25, 9));
		System.out.println(obj.substract(25, 9));
		System.out.println(obj.multiple(25, 9));
		System.out.println(obj.division(25, 9));
	}
}

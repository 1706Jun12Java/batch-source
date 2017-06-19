package q15;

//Write a program that defines an interface having the
//following methods: addition, subtraction, multiplication, 
//and division.  Create a class that implements this interface 
//and provides appropriate functionality to carry out the required 
//operations. Hard code two operands in a test class having a main
//method that calls the implementing class.
public class InterfaceDriver {

	public static void main(String[] args) {

		// create a mathinterface instance, and use methods.
		MathInterface a = new MathInterface();
		System.out.println(a.addition(2, 3));
		System.out.println(a.subtraction(9, 6));
		System.out.println(a.division(8, 2));
		System.out.println(a.multiplication(3, 2));

	}

}

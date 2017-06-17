package q15;

public class Main implements Interface{

	public static void main(String[] args) {
/*		Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
		Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
		Hard code two operands in a test class having a main method that calls the implementing class.*/

	}

	@Override
	public int addition(int n1, int n2) {
		return n1 + n2;
	}

	@Override
	public int subtraction(int n1, int n2) {
		return n1 - n2;
	}

	@Override
	public int multiplication(int n1, int n2) {
		return n1 * n2;
	}

	@Override
	public int division(int n1, int n2) {
		return n1 / n2;
	}

}

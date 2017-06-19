package q15;

//methods are implemented and ready to be used.
public class MathInterface implements Interfaces {

	MathInterface() {
		super();
	}

	@Override
	public int addition(int a, int b) {
		int c = a + b;
		return c;
	}

	@Override
	public int subtraction(int a, int b) {
		int c = a - b;
		return c;
	}

	@Override
	public int division(int a, int b) {
		int c = a / b;
		return c;
	}

	@Override
	public int multiplication(int a, int b) {
		int c = a * b;
		return c;
	}

}

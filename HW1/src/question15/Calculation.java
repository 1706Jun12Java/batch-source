package question15;


public class Calculation implements Test{

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		return a/b;
	}

}

   


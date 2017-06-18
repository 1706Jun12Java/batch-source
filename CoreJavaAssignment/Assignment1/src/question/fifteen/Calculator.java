package question.fifteen;

public class Calculator implements Operators{

	@Override
	public float addition(float a, float b) {
		return a+b;
	}

	@Override
	public float subtraction(float a, float b) {
		return a-b;
	}

	@Override
	public float multiplication(float a, float b) {
		return a*b;
	}

	@Override
	public float division(float a, float b) {
		return a/b;
	}

}

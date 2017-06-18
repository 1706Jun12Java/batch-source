package com.revature.q15;

public class SimpleCalculator implements CalculatorInterface {

	@Override
	public Number addition(Number n1, Number n2) {
		return n1.doubleValue()+n2.doubleValue();
	}

	@Override
	public Number subtraction(Number n1, Number n2) {
		return n1.doubleValue()-n2.doubleValue();
	}

	@Override
	public Number multiplication(Number n1, Number n2) {
		return n1.doubleValue()*n2.doubleValue();
	}

	@Override
	public Number division(Number n1, Number n2) {
		return n1.doubleValue()/n2.doubleValue();
	}

}

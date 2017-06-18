package com.homework1.q15;

public interface InterfaceExample {
	public int addition(int a, int b);
	public int subtraction(int a, int b);
	public int multiplication(int a, int b);
	public int division(int a, int b);
}


class TestInterface implements InterfaceExample{
	
	@Override
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
}
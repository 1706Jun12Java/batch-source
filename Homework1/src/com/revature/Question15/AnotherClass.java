package com.revature.Question15;

public class AnotherClass implements Operations{
	
	@Override
	public void addition(double a, double b) {
		System.out.println(a+" + " +b + " = " + (a+b));
	}

	@Override
	public void subtraction(double a, double b) {
		System.out.println(a+" - " +b + " = " + (a-b));
	}

	@Override
	public void division(double a, double b) {
		System.out.println(a+" / " +b + " = " + (a/b));
	}

	@Override
	public void multiplication(double a, double b) {
		System.out.println(a+" * " +b + " = " + (a*b));
	}

}

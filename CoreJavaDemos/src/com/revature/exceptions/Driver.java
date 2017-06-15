package com.revature.exceptions;

public class Driver {

	public static void main(String[] args) {

		try {
			checkNumber(5);
			checkNumber(4);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void checkNumber(int i) throws BadNumberException, MyException {
		if (i == 3) {
			throw new BadNumberException();
		} else if (i == 4) {
			throw new MyException("this is MyException");
		} else {
			System.out.println("number is fine");
		}
	}

}

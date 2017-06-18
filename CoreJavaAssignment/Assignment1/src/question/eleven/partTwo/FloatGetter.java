package question.eleven.partTwo;

import question.eleven.partOne.FloatKeeper;

public class FloatGetter {

	public static void main(String[] args) {
		
		FloatKeeper fk = new FloatKeeper();
		fk.f1 = (float) 4.25;
		fk.f2 = (float) 6.234;
		
		System.out.println("My value for the float variable, f1 is: " + fk.f1);
		System.out.println("My value for the float variable, f2 is: " + fk.f2);
		
		
	}

}

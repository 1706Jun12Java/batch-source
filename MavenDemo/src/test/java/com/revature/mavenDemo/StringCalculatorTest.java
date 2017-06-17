package com.revature.mavenDemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test(expected = RuntimeException.class)
	public final void moreThanTwoThrowsException(){
		StringCalculator.add("1,2,3");
	}
	
	@Test
	public final void twoNumbersReturnsSum(){
		int sum = StringCalculator.add("2,5");
		assertEquals(7,sum);
	}
	
	@Test
	public final void emptyStringReturnsZero(){
		int sum  = StringCalculator.add("");
		assertEquals(0,sum);
	}
	
	

}

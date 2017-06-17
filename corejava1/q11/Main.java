package corejava1.q11;

import corejava1.q11.anotherPackage.ClassA;

/**
 * 
 * @author Leibniz Berihuete
 * Write a program that would access two float-variables from a class that exists in
 * another package. Note, you will need to create two packages to demonstrate the
 * solution.
 */
public class Main {
	public static void main(String [] args) {
		
		System.out.println("First float: " + ClassA.floatA1);
		System.out.println("Second float: " + ClassA.floatA2);
		
		/* ****************************************************************
		 *  NOTE: I had to import the 'corejava1.q11.anotherPackage.ClassA
		 *  In order to access the variables
		 * 
		 * ****************************************************************/
	}
}

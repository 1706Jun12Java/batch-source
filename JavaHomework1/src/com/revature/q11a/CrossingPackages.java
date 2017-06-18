package com.revature.q11a;
/*
 * Q11. Write a program that would access 
 * two float-variables from a class that exists in another package. 
 * Note, you will need to create two packages to demonstrate the solution.
 * 
 */
import com.revature.q11b.TempClass;
public class CrossingPackages {

	public static void main(String[] args) {
		TempClass test = new TempClass(435.3f,5646.65f);
		System.out.println(test.toString());

	}

}

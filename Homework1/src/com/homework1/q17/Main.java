package com.homework1.q17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter principal: ");
		String principal = s.nextLine();
		System.out.print("Enter rate of interest: ");
		String rate = s.nextLine();
		System.out.print("Enter number of years: ");
		String year = s.nextLine();
		System.out.println(Double.parseDouble(principal)*Double.parseDouble(rate)/100*Double.parseDouble(year));
		s.close();
	}

}

package com.revature.codeChallengeWeek1.leibniz;

public class Main {
	
	public static void main(String [] args) {
		// GIVEN INPUTS:
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String [] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		
		int numOfMutations = Utility.getNumOfMutations(start, end, bank);
		System.out.println(numOfMutations);
	}
}

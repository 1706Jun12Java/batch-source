package com.revature.CodeChallenge;

public class Driver {

	public static void main(String[] args) {
		
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		Utility obj = new Utility();
		obj.minMutation(start, end, bank);

	}

}

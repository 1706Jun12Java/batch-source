package com.revature.codeChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumMutations {

	public static void main(String[] args) {
		
		//create a scanner to read input from user.
		Scanner s = new Scanner(System.in);
		System.out.println("please enter a starting string: ");
		String start = s.nextLine();
		System.out.println("please enter a ending string: ");
		String end = s.nextLine();

		ArrayList<String> geneBank = new ArrayList<String>();
		geneBank.add(start);
		geneBank.add(end);
		for (int i = 0; i < geneBank.size(); i++) {
			System.out.println(geneBank.get(i));
		}
		if (geneMutation(start, end, geneBank) == 0) {
			System.out.println("Mutation are the same");
		} else if (geneMutation(start, end, geneBank) == -1) {
			System.out.println("Mutation cannot happen");
		} else {
			System.out.println(geneMutation(start, end, geneBank) + " mutation occured.");
		}

		s.close();
	}

	// takes in the starting and ending string and compares.
	static int geneMutation(String start, String end, ArrayList<String> a) {

		int count = 0;
		if (start.equalsIgnoreCase(end)) {
			return count; // start and end string are equally the same.
		} else if (start.length() != end.length()) {
			count = -1; // no possible mutation.
			return count;
		} else { // how many characters are different.
			for (int i = 0; i < start.length(); i++) {
				if (start.charAt(i) != end.charAt(i)) {
					a.add(start.substring(i, i + 1));
					count++;
				}
			}
			return count;
		}
	}
}
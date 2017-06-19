package com.week1Challenge;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		//create bank
		ArrayList<String> bank = new ArrayList<String>();
		bank.add("AACCGGTA");
		bank.add("AACCGCTA");
		bank.add("AAACGGTA");
		
		
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		Gene g = new Gene();
		int n = g.numMut(start, end, bank);
		System.out.println(n);
	}
}

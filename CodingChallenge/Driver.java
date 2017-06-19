package com.revature.CodingChallenge;

import java.util.LinkedList;

public class Driver {

	public static void main(String[] args) {

		String gene1 = "AACCGGTT";
		String gene2 = "ATCGGGTA";
		LinkedList<String> bank = new LinkedList<String>();

		Utility geneCheck = new Utility();

		System.out.println("Mutations: " + geneCheck.mutationCheck(gene1, gene2, bank));
		System.out.println("Bank Status Mutations: " + bank);

	}
}

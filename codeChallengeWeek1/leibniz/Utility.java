package com.revature.codeChallengeWeek1.leibniz;
/**
 * 
 * @author Leibniz Berihuete
 * Utility class contains all the methods to complete the getNumOfMutations
 */
public class Utility {
	
	public static int getNumOfMutations(String start, String end, String [] bank) {
		// -1 is the default for no valid mutations
		int mutations = 0;
		
		// String builder for changing content of a string
		StringBuilder strBuilder = new StringBuilder(start);
		
		// If they are equal return 0.
		if(start.equals(end)) {
			return 0;
		}
		
		else {
			// search through each mutation
			for(int i = start.length()-1; i >= 0; i--) {
				
				if(start.charAt(i) != end.charAt(i)) {
					// Make mutation:
					strBuilder.replace(i, i+1, "" + end.charAt(i));
					
					// if the mutation is valid: increase mutation
					if(validGene(bank, strBuilder.toString())) {
						mutations++;
					}
				}
			}
			
			
		}
		
		if(mutations > 0) {
			return mutations;
		}
		//ELSE:
		return -1;
	}
	
	// THIS WILL RETURN WHETHER A GENE IS VALID OR NOT
	private static boolean validGene(String [] bank, String gene) {
		boolean exists = false;
		
		// Search through the bank
		for(int i = 0; i < bank.length; i++) {
			
			if(bank[i].equals(gene)) {
				
				return true; // return true if found. Meaning it is valid
			}
		
		}
		
		return exists;
	}
}

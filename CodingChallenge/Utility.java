package com.revature.CodingChallenge;

import java.util.LinkedList;

public class Utility {

	
	public int mutationCheck(String gene1, String gene2, LinkedList<String> bank){
		int count =0;
		
		char[] start = gene1.toCharArray();
		char[] end = gene2.toCharArray();
		char[] temp = start;
		System.out.println("Start gene: " +start + "\n");
		for(int i=0; i<start.length;i++){
			for(int j=8; j>0; j--){
				if(start[i]!=end[i]){
					temp[i] =end[i];
					System.out.println(temp);
					
					bank.add(temp.toString());
					count++;		
					
				}
			}
		}
		
		System.out.println("\nEnd gene: " +end);
		
		if(count==0)
			return -1;
		return count;
	}

}

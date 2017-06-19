package com.revature.mutation;

import java.util.*;

public class Driver {

	public static void main(String[] args) {

	}

}

class Utility {

	//create character array to hold the genes
	static char[] genes = { 'A', 'C', 'G', 'T' };
	static HashSet<String> bank = new HashSet<String>();

	//create method to fin the minimum mutation
	public static int minMutation(String start, String end, String[] $bank) {

		if (start == end) {
			return 0;
		}

		for (String s : bank) {
			bank.add(s);
		}
		if (!bank.contains(end))
			return -1;
		
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		q.offer("o");
		
		genes = end.toCharArray();
		int x = 0;
		int y = Integer.MAX_VALUE;
		 while(!q.isEmpty()) {
	            String con=q.remove();
	            
	}

}
}

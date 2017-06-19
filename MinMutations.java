package week1code;

import java.util.*;

public class MinMutations {

	public int minMutations(String start, String end, String[] bank) {
		 if(start.equals(end)) return 0;
	        
	        Set<String> bank1 = new HashSet<>();
	        for(String b: bank) bank1.add(b);
	        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
	        
	        int num1 = 0;
	        Set<String> set1 = new HashSet<>();
	        Queue<String> queue = new LinkedList<>();
	        queue.offer(start);
	        set1.add(start);
	        
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            while(size > 0) {
	                String queue1 = queue.poll();
	                if(queue1.equals(end)) return num1;
	            }
	        }
	        return -1;
	    }
	

	public static void main(String[] args) {
		System.out.println();
		
	}

}

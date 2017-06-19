package com.revature.CodeChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Utility {
	
	public int minMutation(String start, String end, String[] bank) {
		
		
		String[] set = new String[3];
			       
		 // if mutation (end) is not in the bank, return -1
		if ( !Arrays.asList(set).contains(end) ) {
		    return -1;
		}
		// convert array of strings to mutable arraylist
		List<String> wordList = Arrays.asList(set);  
		
	     //queue to check on each muatated word
	     Queue<Node> queue = new LinkedList<Node>();
	       
	     //set allowed characters to mutate words.
	     char [] mutationChar = {'A','C','G','T'};
	     
	     //here setting 0 steps away value in container   
	     queue.add(new Node(0,start));
	        
	     while(!queue.isEmpty()){
	            
	        Node con = queue.remove();
	        wordList.remove(con.words);
	            
	        String words = con.words;
	            
	        for(int i=0; i<words.length(); i++){        
	            for(int j=0; j<mutationChar.length; j++){
	                    
	                // logic goes here            
	            
	        }
	    return -1;    
	    }
	}
	 
	class Node{
	    String words;
	    int steps;
	    
	    public Node(int steps,String words){
	        this.words = words;
	        this.steps = steps;
	    }
}

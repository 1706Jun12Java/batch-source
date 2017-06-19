package com.week1Challenge;

import java.util.ArrayList;

public class Gene {
	public int numMut(String start, String end, ArrayList<String> arry){
		if(start.length()!=end.length()){
			return -1;
		}
		if(!arry.contains(end)){
			return -1;
		} else {
			int c = 0;
			for(int i=0;i<start.length();i++){
				if(start.charAt(i)!=end.charAt(i)){
					c+=1;
				}
			}
			return c;
		}	
	}
	
}

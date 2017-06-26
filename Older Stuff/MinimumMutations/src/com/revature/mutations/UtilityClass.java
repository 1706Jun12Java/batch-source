package com.revature.mutations;

public class UtilityClass {
	
	public UtilityClass(String start, String end) {
		super();
		this.setStart(start);
		this.setEnd(end);
	}

	private String start, end;
	
	
	/*If the start and end string are the same, return 0.*/
	public int checkSame(String start, String end){
		int result=1;
			if (start.equals(end))
			{
				result = 0;
			}
		return result;
	}

	public int numberOfMutations(int n){
		int number = 0;
		if(n>0){
			number = n; 
		} else 
			number = -1; 
		
		return number;  
	}

	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}
	
	

}

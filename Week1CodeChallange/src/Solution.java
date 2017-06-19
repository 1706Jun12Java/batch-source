
public class Solution {
	private static final String[] validGene= {"A", "C", "G", "T"};
	public Solution() {
		super();
	}
	public boolean isValidGeneString(String s){
		for(int i=0;i<s.length()-1;i++){
			if(!isValidGene(s.substring(i,i+1))){
				return false;
			}
		}
		return true;
	}
	public boolean isValidGene(String s){
		if(validGene[0].equals(s)==false&&
				validGene[1].equals(s)==false&&
				validGene[2].equals(s)==false&&
				validGene[3].equals(s)==false)
			return false;
		return true;
	}
	public int characterDifference(String s1,String s2){
		int charDiff=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)!=s2.charAt(i))
				charDiff++;
		}
		return charDiff;
		
		
	}
	public int solution(String start,String end, String[] bank){
		if(isValidGeneString(start)==false||isValidGeneString(end)==false||
				start.length()!=end.length())
			return -1;
		boolean inBank=false;
		for(int i=0;i<bank.length;i++){
			if(end.equals(bank[i]))
				inBank=true;
		}
		if(!inBank){
			return -1;
		}
		String change=start;
		int currentToBank=characterDifference(change,end);
		int bankToEnd=characterDifference(change,end);
		int changes=0;
		while(change.equals(end)!=true){
			for(int i=0;i<bank.length;i++){
				if(characterDifference(change,bank[i])==1 && 
						(characterDifference(end,bank[i]) < characterDifference(change,end))){
					change=bank[i];
					changes++;	
				}
			}
		}
		
		
		
		return changes;
	}

}

package codeChallenge1;

public class GeneTherapy {
	private String start = "";
	private String end = "";
	private String[] bank = null;
	
	GeneTherapy(String a, String b, String[] c){
		start = a;
		end = b;
		bank = c;
	}
	public int getGenesComparison(){
		return compareGenes();
	}
	private int compareGenes(){
		if(this.isInBank(end)){
			if(start.equalsIgnoreCase(end)){
				return 0;
			} else if(start.length() != end.length()){
				return -1;
			}else{
				return checkMutations();
			}
		}
		return -1;
	}
	
	private boolean isInBank(String gene){
		if(bank == null){
			return false;
		}
		
		for(String a: bank){
			if(a.equals(gene)){
				return true;
			}
		}
		return false;
	}
	private int checkMutations(){
		int mutation = 0;
		char[] startLetters = new char[start.length()];
		char[] endLetters = new char[end.length()];
		start.getChars(0, start.length(), startLetters, 0);
		end.getChars(0, end.length(), endLetters, 0);
		for(int i = 0; i<startLetters.length;i++){
			if(startLetters[i]!=endLetters[i]){
				mutation++;
			}
		}
		return mutation;
	}
}

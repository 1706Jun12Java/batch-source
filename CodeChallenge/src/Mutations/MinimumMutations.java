package Mutations;

public class MinimumMutations {

	
	public static boolean isValid(String current, String[] allValid ){
		
		
		//for every string, check if valid permutation
		
		for(String str : allValid) { 
			
			if(str==current) return true; 
			
		}
		
		return false;
		
		
	}
	
	/*public static String recursion(String start, String end, int change)
	{
		
		if(start!=end)
		{
			String newPermutation = start.substring(0, change) + end.charAt(change)+ start.substring(change+1); 

			
			return recursion(start, end, change++);
			
		}
		
		
		
		
		
	}*/

	
	public static int Mutations(String start, String end)
	{
		 start = "AACCGGTT"; 
		
		 end = "AAACGGTA"; 
		
		String[] bank={"AACCGGTA", "AACCGCTA", "AAACGGTA"};

		
		if(start == end ) return -1; 
		
		
int numMutations=0;
int i =0 ; // iterator

for( i=0; i<8; i++)
{ 
	if(start.charAt(i)!=end.charAt(i))
	{
		String newPermutation = start.substring(0, i) + end.charAt(i)+ start.substring(i+1); 
		

		System.out.println(newPermutation);
		
		/*if(!isValid(newPermutation, bank))
		{
		
		originally wanted to check if valid,  but answer is wrong because isValid will prove false as the first permutation is not in the bank.
			
			should not have iterated. 
			
		*/}
		
		
			numMutations++; 
		
		
		
		
	}
	
	
	
//}
		
		
		return numMutations;
		
	}
	
	
	public static void main(String[] args) {

	
		System.out.println(Mutations("", ""));
		
		
		
		
	}

}

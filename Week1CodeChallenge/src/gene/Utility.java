package gene;
//compareto
//compareeach char 
public class Utility {
	
	public static int returnNumOfMutations(String start, String end, String[] array) {
//		int arraySize = array.length;
		for (String s: array){
			if (end!=s) {
				continue;
			}
			else {
				int count=0;
				for (int i=0; i<8; i++){
					if (start.charAt(i)!=end.charAt(i)){
						count+=1;
					}
					
					
				}
				if (count==0){
					System.out.println("The start and end string are the same.");
					return count;
				}
				else{
					System.out.println("The following is the minimum number of mutations needed to mutate from start to end:");
					return count;
					
				}
//				return count;
			}
		}
		System.out.println("There is no mutation! The end string is not in the bank.");
		return -1;
	}

}

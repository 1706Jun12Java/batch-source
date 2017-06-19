package Question8;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromesInArrayList {

	public static boolean checkPalin(String str){
		
		int low=0;
		int high=str.length()-1;
			
			
			while(low < high)
			{
				
			if( str.charAt(low)!= str.charAt(high) ) {
					return false; 				
			}
				low++; high--; 
				
				//System.out.println(str.charAt(low) + " is equal to " +str.charAt(high));
				
			}
		
		
		
		
	
		return true;
		
	}
	
	public static void main(String[] args){

		ArrayList<String> arrString = new ArrayList ();
		
		arrString.add("karan"); 
		arrString.add( "madam");
		arrString.add ("tom");
		arrString.add("civic");
		arrString.add("radar");
		arrString.add("jimmy");
		arrString.add("kayak");
		arrString.add("john");
		arrString.add("refer");
		arrString.add( "billy");
		arrString.add("did");
		
		ArrayList<String> arr2 = new ArrayList<String>();
		
		for(String str1 : arrString)
		{
			
			//if It is a palindrome, add it to the list. 
			if(checkPalin(str1)) {
				arr2.add(str1);
				
			} 
			
		}
				
		for(String a : arr2) System.out.println(a); 
			
		}
		
		
		
		
	}



package hw1Q5Package;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		//define variables
		String str;
		int idx;
		String result="";
		Scanner input = new Scanner(System.in);
		//getting string
		System.out.println("Please enter a line of String:");
		str = input.nextLine();
		//getting index number for substring
		System.out.println("Please enter a number:");
		//check if it's integer
		if(!input.hasNextInt()){ 
			//!integer response
			System.out.println("Please enter an integer."); 
		}else{ //is integer response
			idx = input.nextInt();
			//check if input number less than 1
			if(idx < 1){
				//response for index number less than 1
				System.out.println("Please enter a positive integer greater than 2");
			}else{
				//response for index number greater than the length of the string
				if(str.length() < idx){
					System.out.println("Please enter a positive integer smaller than the length of the String.");
				}else{
					for(int i = 0; i < idx-1; i++){
						result += str.charAt(i);
					}
					System.out.println(result);
				}
			}			
		}
	}

}

package hw1Q4Package;

import java.util.Scanner;
public class Question4 {
	public static void main(String[] args) {
		long num;
		long result;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the integer for factorial:");
		//try-catch in case user input a non-integer value
		try{
			num = input.nextLong();
			result = num;
			// 0 factorial is 1
			if(num == 0){
				System.out.println(num + " factorial is 1");
			}else if(num > 0){ //function for positive integer
					for(long i = num; i > 1; i--){
						result *= (i-1);
					}
					System.out.println(num + " factorial is " + result);	
			}else if (num < 0){ //function for negative integer
				
				for(long i = num; i < -1; i++){
					result *= (i-1);
				}
				System.out.println(num + " factorial is " + result);
			
		}
				
		}catch(Exception e){ //output for non-integer type error.
			System.out.println("Only integer allowed. Restart the program and try again");
		}
	}

}

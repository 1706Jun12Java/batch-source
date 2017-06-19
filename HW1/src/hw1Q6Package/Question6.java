package hw1Q6Package;

import java.util.Scanner;

public class Question6 {

	public static void main(String[] args) {
		//defines variables
		int num;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer:");
		//check if it is an integer
		if(input.hasNextInt()){
			num = input.nextInt();
			//function for small numbers like -1, 0, 1
			if(num == 0){
				System.out.println("Even number");
			}else if(num == 1 || num == -1){
				System.out.println("Odd number");
			}else if(num > 1){
				//function for positive integers
				while (num > 0){
					num -= 2;
					if(num == 0){
						System.out.println("Even number");
						break;
					}else if(num==1){
						System.out.println("Odd number");
						break;
					}
				}
			}else if ( num < -1){
				//function for negative integers
				while (num < 0){
					num += 2;
					if(num == 0){
						System.out.println("Even number");
						break;
					}else if(num== -1){
						System.out.println("Odd number");
						break;
					}
				}
			}
			
		}else{
			//response for entering non-integer value
			System.out.println("Please enter an integer");
		}
	input.close();
	}

}

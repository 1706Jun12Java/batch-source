package hw1Q2Package;

//Write a program to display the first 25 Fibonacci numbers beginning at 0.

public class Question2 {
	public static void main(String[] args){
		//Declare the first two number
		int num1 = 0;
		int num2 = 1;
		//To store new number
		int newNum;
		//print out the first 2 numbers before doing the calculation
		System.out.print(num1 + " " + num2 + " ");
		//for loop to calculate new number
		//then print it out and change the variables' value for next calculation
		//since the first 2 numbers have been printed, so only need to get the remaining 23
		for(int i = 0; i < 23; i++){
			newNum = num1 + num2;
			System.out.print(newNum + " ");
			num1 = num2;
			num2 = newNum;
		}
	}
}

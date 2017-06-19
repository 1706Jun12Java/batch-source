package hw1Q14Package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Question14 {
	private String str;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.println("Enter case from 1-3:");
		if(input.hasNextInt()){
			choice = input.nextInt();
			switch(choice){
			case 1:
				Random ran = new Random();
				int num = ran.nextInt(50);
				System.out.println("Square root of " + num + " = " + Math.sqrt(num));
				break;
			case 2:
				Date date = new Date();
				System.out.println("Today's date: " + date.toString());
				break;
			case 3:
				String str = "I am learning Core Java";
				String[] splitStr = str.split(" ");
				for(int i = 0; i<splitStr.length; i++){
					System.out.println(splitStr[i]);					
				}
				break;
			default:
				System.out.println("Invalid number");
			}
		}else{
			System.out.println("Invalid input");
		}
		
	}

}

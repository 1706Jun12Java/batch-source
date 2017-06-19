package Substring;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		//ask user for text input
		System.out.println("Write something: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		// ask user for number input
		System.out.println("Enter end position: ");
		Scanner reader = new Scanner(System.in);
		int end = reader.nextInt();
		//call the getSubstring method
		System.out.println(getSubstring(input, end));
	}

	public static String getSubstring(String text, int end){
		//null string to store subString element
		String subString = "";
		//check if 'end' is within user text input length
		if(end <= text.length()){
			//add each element until the 'end' position to subString
			for(int i=0; i<end; i++){
				subString = subString+text.charAt(i);
			}
			return subString;
		}
		else
			return "Enter valid end position.";
	}
}

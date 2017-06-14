package question5;

import java.util.Scanner;

public class Substring {
	
	public static void main(String[] args){
		System.out.println("Enter a word: ");
		Scanner sc = new Scanner(System.in);
		String uInput = sc.nextLine();
		System.out.println("Enter a end index: ");
		int uNum = Integer.parseInt(sc.nextLine());
		System.out.println("The substring of your word is: " + subString(uInput,uNum));
		sc.close();
	}
	
	public static String subString(String str, int idx){
		String temp = "";
		for(int i = 0;i < idx; i++){
			temp += str.charAt(i);
		}
		return temp;
	}
}

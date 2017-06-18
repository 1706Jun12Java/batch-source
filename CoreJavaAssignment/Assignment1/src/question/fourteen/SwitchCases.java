package question.fourteen;
import static java.lang.Math.sqrt;

import java.util.Arrays;
import java.util.Date;

public class SwitchCases {

	public static void main(String[] args) {
		int caseNum = 1;
		
		switch(caseNum){
			case 1:
				System.out.println(sqrt(100));
				break;
			case 2:
				getTodayDate();
				break;
			case 3:
				splitArray();
				break;
			default:
				caseNum = 1;
				break;
		}
				

	}
	
	public static double getSquareRoot(int n){
		return sqrt(n);
		
	}
	
	public static void getTodayDate(){
		Date date = new Date();
		System.out.println(date);
	}
	
	public static void splitArray(){
		String s = "I am learning Core Java";
		String[] myArray = s.split(" ");
		System.out.println(Arrays.toString(myArray));
		
	}
	

}

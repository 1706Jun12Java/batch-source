package Question14;

import java.util.*;

public class SwitchCase {
	public static void main(String[] args) {

		threeThingsToDo(1);
		threeThingsToDo(2);
		threeThingsToDo(3);

		
	}
	//create switch statement
	public static void threeThingsToDo(Integer i){
		switch(i){
		case 1: //finds sqaure root of a random number from 1 to 100
			int x = (int) (Math.random()*100);
			System.out.print("The square root of "+x +" is: ");
			System.out.println(Math.sqrt(x));
			break;
		case 2: //displays current date
			Date date = new Date();
			System.out.printf("%s %tb %<te, %<tY","Today's date is: ",date);
			break;
		case 3: //split string and store in string array
			String str = "I am learning Core Java";
			String[] str2 = str.split(" ");
			System.out.println("\n"+Arrays.toString(str2));
			break;
		}
	}
}

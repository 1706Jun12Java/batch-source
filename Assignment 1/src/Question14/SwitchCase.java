package Question14;

import java.util.Scanner; 
import java.util.Date;

public class SwitchCase {

	
	public static double sqroot(int x) {
		
		
		return Math.sqrt(x); 
		
		
	}
	
	
	
	
	public static void main(String args[] )
	{
		
		Scanner scan =  new Scanner(System.in); 
		
	int i=0;
	
	do{
		System.out.println("Please enter what option you would like to select"
				+ "\nOption 1:Find a square root\n"
				+ "Option 2:Display the date\n"
				+ "Option 3: Split a space-seperated text\n");
	
		i = scan.nextInt(); 
	
	
	switch(i){
	
	case 1 :  int x; System.out.println("please enter a number that you would like to find the square root of"); x=scan.nextInt(); System.out.println(sqroot(x));  break; 
	case 2 : Date date= new Date(); System.out.println(date); break; 
	case 3 : String str;  System.out.println("please enter a string of space-seperated text ");str = "I am learning Core Java"; String split[] = str.split("//s"); for(String a : split) System.out.print(a + ' '); break; 
	case 4: break; 
	default: System.out.println(" please press '4' to quit "); i= scan.nextInt(); 
	
	
	}
	
	}
	
	while(i!=4);
	scan.close();
}

}
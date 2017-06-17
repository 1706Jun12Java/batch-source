package Q16;

//  Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
//  modify run configuration to test run

public class solution { 
	public static void main(String[] args){ 
		
		if (args.length > 0){
			System.out.println(args[0].length());
		} 
	}
}

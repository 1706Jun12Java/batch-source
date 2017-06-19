package q16;

//Write a program to display the number
//of characters for a string input. 
//The string should be entered as a command 
//line argument using (String [ ] args).
public class SysArgs {

	public static void main(String[] args) {
		int i = 0;
		for (String j : args) {
			i = i + j.length();
		}
		System.out.println(i + args.length - 1);
	}
}


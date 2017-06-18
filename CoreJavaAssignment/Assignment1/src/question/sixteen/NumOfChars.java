package question.sixteen;

public class NumOfChars {

	public static void main(String[] args) {
		
		if(args.length!=0){
			System.out.println("The string, \"" + args[0] + "\" consists of " + args[0].length() + " characters.");
		}
		else
			System.out.println("I did not receive any string args. Please try again.");

		

	}

}

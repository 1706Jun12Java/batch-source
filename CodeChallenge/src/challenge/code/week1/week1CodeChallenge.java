package challenge.code.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class week1CodeChallenge {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String start;
		String end;
		//make input to uppercase and trim them
		System.out.println("Please enter 8 letters with 'A', 'C', 'G' or 'T':");
		start = input.nextLine().toUpperCase().trim();
		System.out.println("Please enter next 8 letters with 'A', 'C', 'G' or 'T':");
		end = input.nextLine().toUpperCase().trim();
		try{
			//check if start and end are both with 8 letter and not empty
			if (start.isEmpty() || start.length() != 8 || end.isEmpty() || end.length() != 8){
				System.out.println("Wrong input");
			}else{
				StringBuilder tempBank = new StringBuilder(start);
				int returnNum=0;
				List<String> bank = new ArrayList<String>();
				//for station for checking the number of mutations
				for(int i =start.length()-1; i>0;i--){
					// check if both string's character at this index is not the same, then perform to count number of mutation
					if(start.charAt(i) != end.charAt(i)){
						//check if this char has either letter A,C,G, or T, otherwise will just break and make returnNum = -2
						if(start.charAt(i) !='A' && start.charAt(i) !='C' && start.charAt(i) != 'G' && start.charAt(i) != 'T'){
							returnNum = -2;
							break;
						}
						//check if this char has either letter A,C,G, or T, otherwise will just break and make returnNum = -2
						if(end.charAt(i) !='A' && end.charAt(i) !='C' && end.charAt(i) != 'G' && end.charAt(i) != 'T'){
							returnNum = -2;
							break;
						}
						//if the characters do correct, then do the count
						tempBank.setCharAt(i, end.charAt(i));
						bank.add(tempBank.toString());
						returnNum++;
						}
				}
				//print out the stuff
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				//skill this line if not possible for mutation
				if(returnNum != -2){
					System.out.println("Bank: " + bank);
				}
				//display return number
				System.out.println("return: " + returnNum);
			}
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
	}
}

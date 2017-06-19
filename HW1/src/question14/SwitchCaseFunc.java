package question14;
import java.util.*;

public class SwitchCaseFunc {

	public static void main(String[] args) {
		System.out.println("Enter a case number: ");
		Scanner s = new Scanner(System.in);
		int myCase = Integer.parseInt(s.nextLine());	
			
			
			switch (myCase) {
			case 1:
				System.out.println("Enter a number to find its square root ");
				double square = Integer.parseInt(s.nextLine());
				System.out.println("The square root is: " + Math.sqrt(square));
				break;
				
			case 2:
				System.out.println(Calendar.getInstance().getTime());
				break;
			case 3:
				 System.out.println("The Following String has been Split");
					String a = "I am learning Core Java";
					String[] b = a.split(" ");
					for(String c: b){
						System.out.println(c);
					}
					break;
			default:
				System.out.println("Not a valid entry");
			}

	}
	}



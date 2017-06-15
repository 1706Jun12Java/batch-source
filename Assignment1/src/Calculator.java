import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String first,second,operator;
		int a, b, result;
		
		System.out.println("Enter number 1:");
		first = keyboard.next();
		System.out.println("Enter number 2:");
		second = keyboard.next();
		System.out.println("operator to use from (+,-,*,/):");
		operator = keyboard.next();	
		
		try{
			a = Integer.parseInt(first);
			b = Integer.parseInt(second);
			
			if(operator.equals("-")){
				result = a-b;
			}
			else if(operator.equals("*")){
				result = a*b;
			}	
			else if(operator.equals("/")){
					result = a/b;
			}
			else{
				result = a + b;
			}
		    System.out.println("Result:"+ result);
			
		} catch(NumberFormatException e){
			System.out.println("Error!!");
		}
		keyboard.close();
				

	}

}


package exercise;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		System.out.println("Insert a Numeric Data Type and two values seperated by ONE space");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String type = "",value1= "",value2= "";
		int currVal = 0;
		for(char i : str.toCharArray()){
			if(i == ' '){
				currVal++;
				continue;
			}	
			switch(currVal){
			case 0:
				type += i;
				break;
			case 1:
				value1 += i;
				break;
			case 2:
				value2 += i;
				break;	
			
			default:
				System.out.println("ONE space");
				return;
			}
		}
		type = type.toLowerCase();
		System.out.print("The result is " );
		try{
			switch(type){
				case "int":
					System.out.println(Integer.valueOf(value1) + Integer.valueOf(value2) );
					break;
				case "float":
					System.out.println(Float.valueOf(value1) + Float.valueOf(value2) );
					break;
				case "double":
					System.out.println(Double.valueOf(value1) + Double.valueOf(value2) );
					break;
				case "long":
					System.out.println(Long.valueOf(value1) + Long.valueOf(value2) );
					break;
				case "short":
					System.out.println(Short.valueOf(value1) + Short.valueOf(value2) );
					break;
				case "byte":
					System.out.println(Byte.valueOf(value1) + Byte.valueOf(value2) );
					break;
				default:
					System.out.println("not obtainable.");
					System.out.println("You may not have entered a numeric data type.");
					break;
		
			}
		}
		catch(NumberFormatException e){ 
			System.out.println("not obtainable.");
			System.out.println("Not sure if your number matches the type.");
		}
		scan.close();
			
	}
	
}

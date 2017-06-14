package stuff;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data type: ");
		String type = sc.nextLine();
		System.out.println("Enter an expression: ");
		String input = sc.nextLine();
		input = input.trim();
		String operation = "";
		String[] array = new String[10];
		if(input.contains("+")){
			operation = "+";
			array = input.split("\\+");
		}else if(input.contains("*")){
			operation ="*";
			array = input.split("\\*");
		}else if(input.contains("/")){
			operation ="/";
			array = input.split("/");
		}else if(input.contains("-")){
			operation ="-";
			array = input.split("\\-");
		}else if(input.contains(" ")){
			operation =" ";
			array = input.split(" ");
		}
		switch(type.toUpperCase()){
		case "BYTE": 
			byte a = Byte.parseByte(array[0]);
			byte b = Byte.parseByte(array[1]);
			if("+".equals(operation)||" ".equals(operation)){
				System.out.println("The sum is: " + (a+b));
			}else if("-".equals(operation)){
				System.out.println("The difference is: " + (a-b));
			}else if("*".equals(operation)){
				System.out.println("The product is: " + (a*b));
			}else{
				System.out.println("The divident is: " + (a/b));
			}
			break;
		case "INTEGER": 
			int c = Integer.parseInt(array[0]);
			int d = Integer.parseInt(array[1]);
			if("+".equals(operation)||" ".equals(operation)){
				System.out.println("The sum is: " + (c+d));
			}else if("-".equals(operation)){
				System.out.println("The difference is: " + (c-d));
			}else if("*".equals(operation)){
				System.out.println("The product is: " + (c*d));
			}else{
				System.out.println("The divident is: " + (c/d));
			}
			break;
		case "SHORT": 
			short e = Short.parseShort(array[0]);
			short f = Short.parseShort(array[1]);
			if("+".equals(operation)||" ".equals(operation)){
				System.out.println("The sum is: " + (e+f));
			}else if("-".equals(operation)){
				System.out.println("The difference is: " + (e-f));
			}else if("*".equals(operation)){
				System.out.println("The product is: " + (e*f));
			}else{
				System.out.println("The divident is: " + (e/f));
			}
			break;
		case "DOUBLE": 
				double g = Double.parseDouble(array[0]);
				double h = Double.parseDouble(array[1]);
				if("+".equals(operation)||" ".equals(operation)){
					System.out.println("The sum is: " + (g+h));
				}else if("-".equals(operation)){
					System.out.println("The difference is: " + (g-h));
				}else if("*".equals(operation)){
					System.out.println("The product is: " + (g*h));
				}else{
					System.out.println("The divident is: " + (g/h));
				}
				break;
		case "LONG": 
			long i = Long.parseLong(array[0]);
			long j = Long.parseLong(array[1]);
			if("+".equals(operation)||" ".equals(operation)){
				System.out.println("The sum is: " + (i+j));
			}else if("-".equals(operation)){
				System.out.println("The difference is: " + (i-j));
			}else if("*".equals(operation)){
				System.out.println("The product is: " + (i*j));
			}else{
				System.out.println("The divident is: " + (i/j));
			}
			break;
		case "FLOAT": 
			float k = Float.parseFloat(array[0]);
			float l = Float.parseFloat(array[1]);
			if("+".equals(operation)||" ".equals(operation)){
				System.out.println("The sum is: " + (k+l));
			}else if("-".equals(operation)){
				System.out.println("The difference is: " + (k-l));
			}else if("*".equals(operation)){
				System.out.println("The product is: " + (k*l));
			}else{
				System.out.println("The divident is: " + (k/l));
			}
			break;
		 default: System.out.println("Operation was not valid");
				break;
			
		}
		sc.close();

	}

}

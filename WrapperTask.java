package task1class;
import java.util.Scanner;  


public class WrapperTask {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		   System.out.println("Enter your first number which is string");  
		   String firstNumber=sc.nextLine(); 
		   
		   System.out.println("Enter your second number which is string");  
		   String secondNumber=sc.nextLine(); 
		   
		   System.out.println("The first number is :"+firstNumber);
		   System.out.println("The second number is :"+secondNumber);
		   
		   //converting String to Integer value.
		   Integer a = Integer.valueOf(firstNumber);
	        System.out.println("The integer value: "+firstNumber);
	       
	        //converting String to Integer value.
	        Integer b = Integer.valueOf(secondNumber);
	        System.out.println("The integer value: "+secondNumber);
	        
	        System.out.println("The addition of two number is :"+(a+b));
	
		 
		   
	
		   
	}

}

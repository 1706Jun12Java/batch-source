package q2;

public class Main {
	
	//Fibonacci using recursion:
	public static int fibonacci(int number)
	{
		if(number == 1 || number == 2)
			return 1;
		
		return fibonacci(number - 1) + fibonacci(number - 2);
		
		
	}

	public static void main(String[] args) {
		// Write a program to display the first 25 Fibonacci numbers beginning at 0. 
		
		for(int i=1; i<=25;i++){
			System.out.println(i + ". " + fibonacci(i)+" ");
		}

	}
	
	
}

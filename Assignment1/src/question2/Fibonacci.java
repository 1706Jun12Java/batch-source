package question2;

public class Fibonacci {
	public static int fibonacci(int number){
		    if ((number == 0) || (number == 1)) // base cases
		      return number;
		    else
		      // recursion step
		      return fibonacci(number - 1) + fibonacci(number - 2);
	}
	
	
	
	
}



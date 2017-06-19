package Question2;

public class Fibonacci {

	static int fib(int a)
	{
		if(a==0 )
		{ return 0;}
		
		else if(a==1 )
		{ 
			return 1; 
		}
		
		else	return fib(a-1) + fib(a-2 );
		
		
	}
	
	
	
	public static void main(String[] args) {

		int one =1; 
		int two=1;
		int count=0;
		
		// System.out.println(fib(25));
		
		for(count=2; count<25; count++)
		{
			//whichever one is greater is the last number
			
			if(two>one) {one+=two; System.out.println(one);}
			else {two+=one; System.out.println(two);}
			
			
		}
		
		
		
	}
	
	
	
	

}

package Question4;


import java.util.Scanner;

public class Nfactorial {

	
	public static void main(String[] args) {

		Scanner scan= new Scanner(System.in);
		
		int N = scan.nextInt(); 
		scan.close();
		
		double sum=1;
		
		
		while(N>1)
		{
			sum*=N;
			N--;
		}
		
		
	//	System.out.println(recursiveFact(N) ) ; 
		
		 System.out.println(sum);

	}

	
	public static int recursiveFact(int N)
	{
		if(N==0)  return 0;
		if(N==1)return 1; 
		
			return N*recursiveFact(N-1);
			
			
		
		
		
		
	}
}

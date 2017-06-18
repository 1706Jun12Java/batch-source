package question.four;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(nFactorial(8));

	}
	
	public static int nFactorial(int n){
		if (n==0){
			return 1;
		}
		else if (n==1){
			return 1;
		}
		else{
			return n * nFactorial(n-1);
			
		}
	}

}

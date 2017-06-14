package question4;
import java.math.BigInteger;
import java.util.Scanner;
public class Nfactorial {
	
	public static void main(String[] args){
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		String uInput = sc.nextLine();
		int num = Integer.parseInt(uInput);
			if(num == 0 ){
				System.out.println("0");
				sc.close();
				return;
			} else if(num == 1){
				System.out.println("1");
				sc.close();
				return;
			} else if(num == 2){
				System.out.println("2");
				sc.close();
				return;
			} else if(num >= 13){
				BigInteger disGonnaBeBig = BigInteger.valueOf(num);
				System.out.println(factorial(disGonnaBeBig));
			}else{
			System.out.println(factorial(num));
			sc.close();
			}
	}
	public static int factorial(int a){
		if(a != 1){
			return a * factorial(a-1);
		} else{
			return 1;
		}
	}
	
	public static BigInteger factorial(BigInteger n) {
	    BigInteger result = BigInteger.ONE;

	    while (!n.equals(BigInteger.ZERO)) {
	        result = result.multiply(n);
	        n = n.subtract(BigInteger.ONE);
	    }

	    return result;
	}
}

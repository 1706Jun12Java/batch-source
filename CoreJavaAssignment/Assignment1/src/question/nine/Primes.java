package question.nine;
import java.util.ArrayList;

public class Primes {
	
	public static void main(String[] args){
		ArrayList<Integer> myArrayList = new ArrayList<>();
		for (int i=1; i<101; i++){
			myArrayList.add(i);
		}
		
		for (Integer num: myArrayList){
			if(isPrime(num)==true){
				System.out.println(num);
			}
		}
	}

	public static boolean isPrime(int n){
		if(n==1){
			return false;
		}
		for(int i=2; i<n; i++){
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}

}
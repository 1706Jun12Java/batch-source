import java.util.ArrayList;
import java.util.List;

public class Prime {

	public Prime() {
		// TODO Auto-generated constructor stub
	}
	public void checkPrime(int...numbers) {
		List<Integer> primes = new ArrayList<>();
		for(int num:numbers) {
			if(isPrime(num)) {
				primes.add(num);
				for(Integer x:primes) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
		}
		
	}
	public boolean isPrime(int x) {
		boolean prime=true;
		if(x==1) {
			return false;
		}
		for(int i=2;i<x;i++) {
			if(x%i==0) {
				prime=false;
			}
		}
		return prime;
	}
}

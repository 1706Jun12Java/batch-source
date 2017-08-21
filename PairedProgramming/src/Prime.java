
public class Prime {

	public Prime() {
		
	}
	
	public void checkPrime(int... numbers){ // sends in array of integers
	
		for (int n : numbers){
			int m = n/2;
			for (int i=2;i<m;i++){
				if (n%i==0){
					System.out.println(" ");
				}
				else System.out.println(n + " ");	
			}
		
		}
		
	}

}


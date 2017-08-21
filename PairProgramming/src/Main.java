public class Main {
	
	interface MyInterface {
	    boolean isOdd(int n);
	}
	
	interface MyInterface2 {
	    boolean isPrime(int n);
	}

	public static void main(String[] args) {
		
		MyInterface oddOrNot;
        // Lambda expression
        oddOrNot = n -> (n % 2) == 0;
        System.out.println("4 is even " + oddOrNot.isOdd(4)); 
        System.out.println("3 is even " + oddOrNot.isOdd(3)); 
        
        MyInterface2 primeOrNot;
        primeOrNot = k -> (Math.sqrt(k) % k) == 0;
        System.out.println("29 is even " + primeOrNot.isPrime(29)); 
        System.out.println("36 is even " + primeOrNot.isPrime(36));
	}
}

package Fibonacci;

public class Fibonacci_num {
	 
    public static void main(String a[]){
         
         int fibCount = 25;
         //declare empty int array with size of 25 that would store Fib numbers
         int[] fib = new int[fibCount];
         //add first two elements to the array
         fib[0] = 0;
         fib[1] = 1;
         //loop starts from 2 because 0 and 1 are already in the array
         for(int i=2; i < fibCount; i++){
             fib[i] = fib[i-1] + fib[i-2];
         }
 
         // print the contents of the Fib numbers array
         for(int i=0; i< fibCount; i++){
                 System.out.print(fib[i] + " ");
         }
    }
}

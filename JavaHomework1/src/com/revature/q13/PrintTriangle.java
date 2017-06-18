package com.revature.q13;
/*
 * Q13. Display the triangle on the console as follows using any type of loop.  
 * Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

 * 
 */
public class PrintTriangle {

	public static void main(String[] args) {
		printTriangle(4);
		
	}
	
	public static void printTriangle(int depth){
		int count=0;
		for(int i=0;i<depth;i++){
			for(int j=0;j<=i;j++){
				if(count%2==0){
					System.out.print("0 ");
				}
				else{
					System.out.print("1 ");
				}
				count++;
			}
			System.out.println();
		}
	}

}

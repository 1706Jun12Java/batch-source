package com.nima.q13;

public class Q13 {
    
    public static void main(String[] args){
        
        //nested loops to print the triangle
        for (int i = 1; i <= 4; i++) {  
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) { //if its even, print 1s
                    System.out.print("0 ");
                } else {//if its odd, print 0s
                    System.out.print("1 ");
                }
            }
            System.out.println("");
        }
    }
    
}
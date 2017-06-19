package com.nima.q17;

import java.util.Scanner;

public class Q17 {
    
    public static void main(String[]args){
        
        Scanner in = new Scanner(System.in);    //scanner object for inputs
        //taking inputs from user
        System.out.print("Enter Principal: ");
        double Principal = in.nextDouble();
        System.out.print("Enter Rate: ");
        double Rate = in.nextDouble();
        System.out.print("Enter Time: ");
        double Time = in.nextDouble();
        //calculating Interest
        double Interest = Principal* Rate* Time;
        //Displaying Interest
        System.out.println("Interest Is: "+Interest);
    }
    
}

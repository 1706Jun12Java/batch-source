/*
 * Write a program that calculates the simple interest on the principal, rate of interest
 * and number of years provided by the user. Enter principal, rate and time through the
 * console using the Scanner class. Interest = Principal* Rate* Time
 */
package com.Interest;
import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		// prompt user to enter principle, years, rate
        Scanner scanner = new Scanner(System.in);
              
        System.out.println("Please enter principle amount :");
        float amount = scanner.nextFloat();
      
        System.out.println("Enter time in years : ");
        float time = scanner.nextFloat();
      
        System.out.println("Enter annual rate in %. \nExample: 7% is 0.07: ");
        float rate = scanner.nextFloat();
      
        float interest = simpleInterest(amount, rate, time);
      
        System.out.println("Interest due at the end of the term is : " + interest);
    }
  
    public static float simpleInterest(float principle, float rate, float time){
        return (principle*rate*time);
	}

}

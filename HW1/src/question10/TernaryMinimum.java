package question10;

import java.util.Scanner;
public class TernaryMinimum{
    public static void main(String[] args) 
    {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a = s.nextInt();
        System.out.println("Enter Second number:");
        int b = s.nextInt();
        int c = (a < b) ? a:b;
       
        System.out.println("The Minimum number is "+ c);
    }
}
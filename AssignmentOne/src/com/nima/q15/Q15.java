package com.nima.q15;

public class Q15 implements Calculator{
    
    //Main method to test the program
    public static void main(String[] args){
        Q15 q = new Q15();
        //To numbers to test the methods
        int num1 = 10;
        int num2 = 5;
        //calling method with nuber to test them
        q.addition(num1, num2);
        q.subtraction(num1, num2);
        q.multiplication(num1, num2);
        q.division(num1, num2);
        
    }
    //All interface methods implemented here
    @Override
    public void addition(int num1, int num2) {
        System.out.println("Addition: "+(num1+num2));
    }

    @Override
    public void subtraction(int num1, int num2) {
        System.out.println("Subtraction: "+(num1-num2));
    }

    @Override
    public void multiplication(int num1, int num2) {
        System.out.println("Multiplication: "+num1*num2);
    }

    @Override
    public void division(int num1, int num2) {
        System.out.println("Division: "+num1/num2);
    }
    
}
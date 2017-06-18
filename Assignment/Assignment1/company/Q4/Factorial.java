package com.company.Q4;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(7));
    }
    private static int factorial(int N){
        int val = N;

        while(N > 1){
            N--;
            val *= N;
        }

        return val;
    }
}

package com.company.Q10;

public class Minimum {

    public static void main(String[] args) {
        System.out.println(minimumValue(5,8));
        System.out.println(minimumValue(10,8));
        System.out.println(minimumValue(15,8));
        System.out.println(minimumValue(1,8));
    }

    public static int minimumValue(int a, int b){
        return (a < b) ? a : b;
    }
}

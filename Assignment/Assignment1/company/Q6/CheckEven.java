package com.company.Q6;

public class CheckEven {
    public static void main(String[] args){
        System.out.println(isEven(11));
    }

    private static boolean isEven(int value){
        if ((value/2)*2 == value)
            return true;
        return false;
    }
}

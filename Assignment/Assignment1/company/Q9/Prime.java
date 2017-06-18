package com.company.Q9;

import java.util.ArrayList;

public class Prime {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            list.add(i);
            if (checkPrime(i))
                System.out.println(i);
        }

    }

    public static boolean checkPrime(int value){
        if (value < 2)
            return false;

        for(int i = 2; i <= value/2; i++){
            if (value % i == 0)
                return false;
        }

        return true;
    }
}



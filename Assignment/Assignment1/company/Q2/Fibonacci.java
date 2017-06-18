package com.company.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {

        int input = 25;

        fib(input);

    }

    private static void fib(int input){

        int counter = 0,
                val = 0,
                secondVal = 1,
                temp;

        List list = new ArrayList<> ();

        list.add(val);
        while(counter < input){
            temp = secondVal;
            secondVal += val;
            val = temp;

            list.add(val);
            counter++;
        }

        System.out.println(Arrays.toString(list.toArray()));
    }
}

package com.company.Q14;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class SwitchCase {

    public static void main(String[] args) {

        switchCase(1);
        switchCase(2);
        switchCase(3);
    }

    public static void switchCase(int value){
        String string = "I am learning Core Java";

        switch (value){
            case 1:
                System.out.println(Math.sqrt(value));
                break;
            case 2:
                System.out.println(new Date());
                break;
            case 3:
                String[] splitString = string.split(" ");
                System.out.println(Arrays.toString(splitString));
                break;
            default:
                return;
        }

    }

}

package com.company.Q5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubString {

    public static void main(String[] args) {

        String string = "abcdefg";
        int limit = 3;

        System.out.println(subString(string, limit));

    }

    private static String subString(String string, int limit){

        char[] newString = new char[limit];

        for (int i = 0; i < limit; i++){
            newString[i] = string.charAt(i);
        }

        return new String(newString);
    }
}
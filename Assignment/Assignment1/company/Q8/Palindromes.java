package com.company.Q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> palindromeList = new ArrayList<>();

        list.add("karan");
        list.add("madam");
        list.add("tom");
        list.add("civic");
        list.add("radar");
        list.add("jimmy");
        list.add("kayak");
        list.add("john");
        list.add("refer");
        list.add("billy");
        list.add("did");

        for (String i: list) {
            if (isPalindrome(i))
                palindromeList.add(i);
        }
        System.out.println(palindromeList.toString());
    }

    public static boolean isPalindrome(String s){

        for (int i = 0; i < s.length()/2 ; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

}

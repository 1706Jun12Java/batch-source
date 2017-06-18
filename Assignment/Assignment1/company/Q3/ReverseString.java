package com.company.Q3;

public class ReverseString {
    public static void main(String[] args) {

        String input = "noodle";
        System.out.println(reverse(input));

        System.out.println(input);

    }

    private static String reverse(String string){

        if (string.length() <= 1)
            return string;

        return reverse(string.substring(1)) + string.charAt(0);
    }

}

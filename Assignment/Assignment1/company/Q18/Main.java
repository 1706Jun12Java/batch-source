package com.company.Q18;

public class Main {

    public static void main(String[] args) {
        SubCheckString test = new SubCheckString();

        String string = "tesTing";
        String string2 = "testing";

        String value = "10";

        System.out.println(string + " has uppercase: " + test.checkUpperCase(string));
        System.out.println(string2 + " has uppercase: " + test.checkUpperCase(string2));

        System.out.println(string + " to uppercase: " + test.toUpperCase(string));
        System.out.println(string2 + " to uppercase: " + test.toUpperCase(string2));

        test.addTen(value);
    }
}

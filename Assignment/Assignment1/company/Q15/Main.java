package com.company.Q15;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        Example test = new Example();
        DecimalFormat formatNum = new DecimalFormat("0.##");

        System.out.println(formatNum.format(test.addition(33.2,4)));
        System.out.println(formatNum.format(test.subtraction(7,3)));
        System.out.println(formatNum.format(test.multiplication(5,3)));
        System.out.println(formatNum.format(test.division(13,2)));
    }
}

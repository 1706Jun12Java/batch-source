package com.company.Q17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("To calculate rate of interest");
        System.out.println("Please enter \"Principal Rate Year\"");

        String input = scan.nextLine();

        String[] inputStrings = input.split(" ");

        try {
            double principal = Double.parseDouble(inputStrings[0]);
            double rate = Double.parseDouble(inputStrings[1]);
            double years = Double.parseDouble(inputStrings[2]);

            Interest interest = new Interest(principal, rate, years);
            System.out.println(interest.getInterest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

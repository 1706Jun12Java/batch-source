package com.casting;

import java.util.Scanner;

public class Casting {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter \"Datatype Number Number\" ");

        String input = scan.nextLine();

        String[] splitInput = input.split("\040");

        sum(splitInput);

        scan.close();
    }

    public static void sum(String[] input){

        String numType = input[0];
        String val1 = input[1];
        String val2 = input[2];

        switch (numType.toLowerCase()) {
            case "byte":
                System.out.println(Byte.parseByte(val1) + Byte.parseByte(val2));
                break;
            case "int":
                System.out.println(Integer.parseInt(val1) + Integer.parseInt(val2));
                break;
            case "short":
                System.out.println(Short.parseShort(val1) + Short.parseShort(val2));
                break;
            case "double":
                System.out.println(Double.parseDouble(val1) + Double.parseDouble(val2));
                break;
            case "float":
                System.out.println(Float.parseFloat(val1) + Float.parseFloat(val2));
                break;
            case "long":
                System.out.println(Long.parseLong(val1) + Long.parseLong(val2));
                break;
        }
    }
}

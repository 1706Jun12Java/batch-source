package com.revature.calculator;

import java.util.Scanner;

/**
 * Simple addition calculator.
 *
 * Created by John on 6/14/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Enter the data-type (1 - int, 2 - long, 3 - float, 4 - double) you want to add, then the values (max: 2 values)!");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String [] values = input.split(" ");
        int numDataType = Integer.parseInt(values[0] );
        Number result = 0;

        switch (numDataType)
        {
            case 1:
                result = addition(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                break;
            case 2:
                result = addition(Long.parseLong(values[1]), Long.parseLong(values[2]));
                break;
            case 3:
                result = addition(Float.parseFloat(values[1]), Float.parseFloat(values[2]));
                break;
            case 4:
                result = addition(Double.parseDouble(values[1]), Double.parseDouble(values[2]));
                break;

            default:
                System.out.println("Invalid data-type number");
        }

        System.out.println("result: "  + result);
        in.close();
    }

    private static long addition(long a, long b)
    {
        return a + b;
    }

    private static float addition(float a, float b)
    {
        return a + b;
    }

    private static double addition(double a, double b)
    {
        return a + b;
    }

    private static int addition(int a, int b)
    {
        return a + b;
    }

}

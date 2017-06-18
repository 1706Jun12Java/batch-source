package Question14;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases:
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a sting array.
 * “I am learning Core Java”
 * <p>
 * Created by John on 6/17/2017.
 */
public class SwitchCaseExample
{
    public static void main(String[] args)
    {
        String str = "I am learning core Java";
        String[] strArray;
        int num;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number you want to execute:\n" +
                "1 - Find the square root of a number you enter\n" +
                "2 - Display today's date\n" +
                "3 - Display a string");

        int input = in.nextInt();

        switch (input)
        {
            case 1:
                System.out.println("Enter a number");
                num = in.nextInt();
                System.out.println("The Square root of " + num + " is " + Math.sqrt(num));
                break;
            case 2:
                System.out.println("Today date is: " + LocalDate.now());
                break;
            case 3:
                System.out.println(str);
                strArray = str.split(" ");
                System.out.println("Spilt using String.split method: " + Arrays.toString(strArray));
                break;
            default:
                System.out.println("No operation assign with that number!");
        }

        in.close();
    }
}

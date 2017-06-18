package Question17;

import java.util.Scanner;

/**
 * Write a program that calculates the simple interest on the principal, rate of interest
 * and number of years provided by the user. Enter principal, rate and time through the
 * console using the Scanner class.
 * <p>
 * Interest = Principal* Rate* Time
 * <p>
 * Created by John on 6/18/2017.
 */
public class PrincipleInterestExample
{

    public static void main(String[] args)
    {
        int interest;
        double rate;
        int principle;
        int years;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your principle amount: ");
        principle = input.nextInt();

        System.out.println("Now enter your rate of interest: ");
        rate = input.nextDouble();

        System.out.println("Finally, enter how long will you not touch it: ");
        years = input.nextInt();

        interest = calculateInterest(principle, rate, years);
        System.out.println("you will accumulate " + interest + " in interest");
    }

    /**
     * Calculate the simple interest for the amount entered
     *
     * @param p The amount of money
     * @param r The percentage rate of your interest
     * @param y The amount of years the rate will remain the same
     * @return The simple interest
     */
    static int calculateInterest(int p, double r, int y)
    {
        r = r / 100;
        return (int) (p * r * y);
    }
}

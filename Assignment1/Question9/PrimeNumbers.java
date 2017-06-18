package Question9;

import java.util.ArrayList;

/**
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
 * numbers to the console.
 * <p>
 * Created by John on 6/17/2017.
 */
public class PrimeNumbers
{
    public static void main(String[] args)
    {
        ArrayList<Integer> numberList = new ArrayList<>();

        for (int i = 1; i <= 100; i++)
        {
            numberList.add(i);
        }

        printPrimes(numberList);
    }

    private static void printPrimes(ArrayList<Integer> list)
    {
        for (int x : list)
        {
            if (isPrime(x))
                System.out.print(x + " ");
        }
    }

    /**
     * Check whether or not a number is a prime by using trial by division test.
     * It calculate a max (ceiling) number by rounding the square root of the number.
     * Then from 2 to the ceiling check if any of those number are evenly divisible.
     * <p>
     * (note): 0 and 1 are not primes, and 2 is the only even prime number.
     *
     * @param number The numeric number to be checked
     * @return returns true if it is a prime. otherwise, false
     */
    public static boolean isPrime(int number)
    {
        if (number == 1 || number == 0)
            return false;

        if (number == 2)
            return true;

        Double temp = Math.sqrt((double) number);
        int ceiling;

        if (temp.compareTo((number / 2 + .5d)) >= 0)
            ceiling = (int) (temp + 1);
        else
            ceiling = temp.intValue();

        for (int i = 2; i <= ceiling; i++)
        {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}

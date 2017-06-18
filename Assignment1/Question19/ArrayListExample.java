package Question19;

import Question9.PrimeNumbers;

import java.util.ArrayList;

/**
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
 * the even numbers up and display the result. Add all the odd numbers up and display the
 * result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * <p>
 * Created by John on 6/18/2017.
 */
public class ArrayListExample
{
    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
        {
            numbers.add(i);
        }

        System.out.println(numbers);

        printTotalEvenNumber(numbers);
        printTotalOddNumber(numbers);
        removePrimeNumbers(numbers);

        System.out.println(numbers);
    }

    static void printTotalEvenNumber(ArrayList<Integer> list)
    {
        int total = 0;

        for (int i : list)
        {
            if (i % 2 == 0)
                total += i;
        }

        System.out.println(total);
    }

    static void printTotalOddNumber(ArrayList<Integer> list)
    {
        int total = 0;

        for (int i : list)
            if (i % 2 != 0)
                total += i;

        System.out.println(total);
    }

    /**
     * Check whether or not a number is a prime by using trial by division test.
     * It calculate a max (ceiling) number by rounding the square root of the number.
     * Then from 2 to the ceiling check if any of those number are evenly divisible.
     * Then removes the numbers from the list.
     * <p>
     * (note): 0 and 1 are not primes, and 2 is the only even prime number.
     *
     * @param list the list of numbers to be iterate through
     */
    static void removePrimeNumbers(ArrayList<Integer> list)
    {
        // lambda(functional) method call
        // Calls another class, PrimeNumbers, method (isPrime)
        list.removeIf(PrimeNumbers::isPrime);
    }
}

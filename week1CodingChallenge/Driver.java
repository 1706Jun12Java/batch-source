package week1CodingChallenge;

import week1CodingChallenge.util.MutationCalculation;

/**
 * Created by John on 6/19/2017.
 */
public class Driver
{
    public static void main(String[] args)
    {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        MutationCalculation mutationCalculation = new MutationCalculation();
        System.out.println(mutationCalculation.minNumberOfMutation(start, end, bank));
    }
}

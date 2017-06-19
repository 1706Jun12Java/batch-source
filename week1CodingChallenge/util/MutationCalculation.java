package week1CodingChallenge.util;

/**
 * Created by John on 6/19/2017.
 */
public class MutationCalculation
{
    public int minNumberOfMutation(String start, String end, String[] bank)
    {
        if (start.equals(end))
            return 0;

        int mutation = 0;

        for (String aBank : bank)
        {
            if (end.compareTo(aBank) != 0)
                mutation++;
        }

        return mutation;
    }
}

package Question8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a program that stores the following strings in an ArrayList and saves all the
 * palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
 * <p>
 * Created by John on 6/17/2017.
 */
public class PalindromeExample
{

    public static void main(String[] args)
    {
        String[] str = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",
                "refer", "billy", "did"};
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<String> palStrList = new ArrayList<>();

        strList.addAll(Arrays.asList(str));
        System.out.println(strList);

        for (String x : strList)
            if (isPalindrome(x))
                palStrList.add(x);

        System.out.println(palStrList);
    }

    private static boolean isPalindrome(String s)
    {
        StringBuilder stringBuilder = new StringBuilder(s);

        return stringBuilder.reverse().toString().equalsIgnoreCase(s);
    }
}

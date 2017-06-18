package Question3;

/**
 * Reverse a string without using a temporary variable. Do NOT use reverse() in the
 * StringBuffer or the StringBuilder APIs.
 * <p>
 * Created by John on 6/13/2017.
 */
public class ReverseStringExample
{
    public static void main(String[] args)
    {
        String ex = "simple";

        reverseString(ex);
    }

    static void reverseString(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            s = s.substring(1, s.length() - i)
                    + s.substring(0, 1)
                    + s.substring(s.length() - i, s.length());
        }

        System.out.println(s);
    }
}

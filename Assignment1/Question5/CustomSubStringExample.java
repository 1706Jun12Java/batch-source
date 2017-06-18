package Question5;

/**
 * Write a substring method that accepts a string str and an integer idx and
 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use
 * any of the existing substring methods in the String, StringBuilder,
 * or StringBuffer APIs.
 * <p>
 * Created by John on 6/16/2017.
 */
public class CustomSubStringExample
{
    public static void main(String[] args)
    {
        String ex = "example";

        try
        {
            ex = customSubString(ex, 3);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(ex);
    }

    static String customSubString(String str, int idx) throws Exception
    {
        // idx isn't in range, should return or just throw an exception
        if (idx > str.length())
            throw new Exception("idx is greater than the string length");

        char[] result = new char[str.length()];

        for (int i = 0; i < idx; i++)
        {
            result[i] = str.charAt(i);
        }

        return new String(result);
    }
}

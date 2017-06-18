package Question1;

import java.util.Arrays;

/**
 * A simple BubbleSort Example
 * <p>
 * Created by John on 6/13/2017.
 */

public class BubbleSortExample
{
    public static void main(String[] args)
    {
        int[] values = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        bubbleSort(values);
        System.out.println(Arrays.toString(values));
    }

    /**
     * A sorting algorithm that compares each value and the value next to it
     * to "bubbles up" the largest value.
     * Once it reaches the end of the list, the largest value should be at the end
     * and the algorithm repeats itself, as the length of traversal decreases,
     * until sorted.
     *
     * @param list an array of integer values
     */
    private static void bubbleSort(int[] list)
    {
        for (int i = list.length - 1; i > 1; i--)
            for (int j = 0; j < i; j++)
                if (list[j] > list[j + 1])
                {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
    }
}

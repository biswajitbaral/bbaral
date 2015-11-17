package sorting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Constraints-- N numbers.
 * 
 * All numbers should be d digits.
 */
public class RadixSort
{
    public void radixSort(int[] ar, int d)
    {

        Queue[] data = new Queue[10];
        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < ar.length; j++)
            {
                int x = dig(ar[j], i);

                if (data[x] == null)
                {
                    data[x] = new LinkedList();

                }
                data[x].offer(ar[j]);

            }
            int k = 0;
            for (int j = 0; j < data.length; j++)
            {
                if (data[j] != null && !data[j].isEmpty())
                {
                    while (data[j].peek() != null)
                    {
                        ar[k] = (int) data[j].poll();
                        k++;
                    }

                }
            }
            printArray(ar);
        }
        printArray(ar);
    }

    public void printArray(int[] ar)
    {

        for (int i = 0; i < ar.length; i++)
        {
            System.out.print(" " + ar[i]);
        }
        System.out.println();
    }

    int dig(int a, int b)
    {
        int i, digit = 10;
        int tmp = 0;
        for (i = b; i >= 0; i--)
        {
            tmp = a % digit;
            a = a / digit;
        }

        return tmp;
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 312, 427, 632, 210, 127, 236, 982, 531 };

        int d = 3;

        RadixSort rs = new RadixSort();

        System.out.println(rs.dig(321, 2));
        rs.printArray(arr);
        rs.radixSort(arr, d);

    }

}

package dp.HackerRank;

import java.util.Scanner;

public class SubstringDiff
{

    /**
     * @param args
     */

    void calc_diff()
    {

    }

    public static int maxSubStrDiff(int num, String str1, String str2)
    {

        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        int[][] data = new int[chr2.length + 1][chr1.length + 1];
        int[][] diff_array = new int[chr2.length][chr1.length];
        int L1 = chr1.length;
        int L2 = chr2.length;

        for (int i = 0; i < L1; i++)
        {
            for (int j = 0; j < L1; j++)
            {
                diff_array[i][j] = (chr1[i] == chr2[j] ? 0 : 1);
            }
        }
        int front_pointer, back_ptr1, back_ptr2, front_sum1, front_sum2, curr_max = -1;
        int back_sum1, back_sum2;
        for (int i = 0; i < L1; i++)
        {
            front_sum1 = front_sum2 = back_sum1 = back_sum2 = 0;
            back_ptr1 = back_ptr2 = -1;
            for (front_pointer = 0; front_pointer + i < L1; front_pointer++)
            {
                front_sum1 += diff_array[front_pointer][i + front_pointer];
                front_sum2 += diff_array[i + front_pointer][front_pointer];
                while (front_sum1 - back_sum1 > num)
                {
                    back_ptr1++;
                    back_sum1 += diff_array[back_ptr1][i + back_ptr1];
                }
                while (front_sum2 - back_sum2 > num)
                {
                    back_ptr2++;
                    back_sum2 += diff_array[i + back_ptr2][back_ptr2];
                }

                if (front_pointer - back_ptr1 > curr_max)
                {
                    curr_max = front_pointer - back_ptr1;
                }

                if (front_pointer - back_ptr2 > curr_max)
                {
                    curr_max = front_pointer - back_ptr2;
                }

            }
        }
        // System.out.println(curr_max);

        return curr_max;
    }

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.next());

        while (t-- > 0)
        {
            int a = Integer.parseInt(in.next());
            String str1 = in.next();
            String str2 = in.next();
            System.out.println(maxSubStrDiff(a, str1, str2));

        }

    }

}

package dp;

/*
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence
 * 
 * 
 */

public class MaxSumIncSubsequence
{

    /**
     * @param args
     */
    public static int maxsumIncseq(int[] num)
    {

        int[] maxVal = new int[num.length];
        int[] loc = new int[num.length];

        for (int i = 0; i < num.length; i++)
        {
            maxVal[i] = num[i];
            loc[i] = i;
        }

        int max = 0;
        for (int i = 1; i < num.length; i++)
        {

            for (int j = 0; j < i; j++)
            {

                if (num[j] >= num[i])
                {
                    continue;
                }
                else
                {
                    if (maxVal[j] + num[i] > maxVal[i])
                    {
                        loc[i] = j;
                        maxVal[i] = maxVal[j] + num[i];
                        if (max < maxVal[i])
                        {
                            max = maxVal[i];
                        }
                    }
                }
            }
        }

        int index = 0;
        for (int k = 0; k < num.length; k++)
        {
            if (max == maxVal[k])
            {
                index = k;
                break;
            }

        }

        while (index > 0)
        {
            System.out.print(num[index] + " ");
            index = loc[index];
            if (index == 0)
            {
                System.out.println(num[index]);
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] num =
        { 4, 6, 1, 3, 8, 4, 6 };

        System.out.println(maxsumIncseq(num));

    }

}

package dp;

public class LongIncSubsequence
{

    /**
     * * Find a subsequence in given array in which the subsequence's elements are in sorted order, lowest to highest,
     * and in which the subsequence is as long as possible
     * 
     * Solution : Dynamic Programming is used to solve this question. DP equation is if(arr[i] > arr[j]) { T[i] =
     * max(T[i], T[j] + 1 }
     * 
     * Time complexity is O(n^2). Space complexity is O(n)
     * 
     * Reference http://en.wikipedia.org/wiki/Longest_increasing_subsequence
     * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
     */

    public static void main(String[] args)
    {

        int[] arr =
        { 3, 4, -1, 0, 6, 2, 3 };

        int len = arr.length;

        int[] T = new int[len];
        int actualSolution[] = new int[len];

        for (int i = 0; i < len; i++)
        {
            T[i] = 1;
            actualSolution[i] = i;
        }

        for (int i = 1; i < len; i++)
        {

            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j])
                {
                    if (T[j] + 1 > T[i])
                    {
                        T[i] = T[j] + 1;
                        // set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }

            }

        }
        // find the index of max number in T
        int maxIndex = 0;
        for (int i = 0; i < T.length; i++)
        {
            if (T[i] > T[maxIndex])
            {
                maxIndex = i;
            }
        }
        System.out.println(T[maxIndex]);

        int t = maxIndex;
        int newT = maxIndex;
        do
        {
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        } while (t != newT);

    }

}

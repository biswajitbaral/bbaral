package dp;

/*
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
 A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.

 Examples:

 Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
 Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)

 Input arr[] = {12, 11, 40, 5, 3, 1}
 Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)

 Input arr[] = {80, 60, 30, 40, 20, 10}
 Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30, 20, 10)
 */

public class LBitonicSequence
{

    /**
     * @param args
     */

    // creating array for longest increasing sequence from left to right.
    public static int[] LongestInSequencefromLtoR(int[] arr)
    {
        int len = arr.length;

        int[] tmp = new int[len];
        for (int i = 0; i < len; i++)
        {
            tmp[i] = 1;
        }

        for (int j = 1; j < len; j++)
        {
            for (int i = 0; i < j; i++)
            {

                if (arr[i] < arr[j])
                {
                    tmp[j] = (tmp[i] + 1) > tmp[j] ? tmp[i] + 1 : tmp[j];

                }
            }
        }
        return tmp;
    }

    // creating array for longest increasing sequence from right to left.
    public static int[] LongestInSequencefromRtoL(int[] arr)
    {

        int len = arr.length;

        int[] tmp = new int[len];
        for (int i = 0; i < len; i++)
        {
            tmp[i] = 1;
        }

        for (int i = len - 2; i >= 0; i--)
        {
            for (int j = len - 1; j > i; j--)
            {
                if (arr[i] > arr[j])
                {
                    tmp[i] = (tmp[j] + 1) > tmp[i] ? tmp[j] + 1 : tmp[i];

                }

            }

        }
        return tmp;
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 2, -1, 4, 3, 5, -1, 3, 2 };

        int[] arrLR = LongestInSequencefromLtoR(arr);
        int[] arrRL = LongestInSequencefromRtoL(arr);

        int maxBitonic = 0;
        // max bitonic length will be calculated by adding the both array elements. after that substrtact by one.
        for (int i = 0; i < arr.length; i++)
        {
            maxBitonic = maxBitonic < (arrLR[i] + arrRL[i] - 1) ? arrLR[i] + arrRL[i] - 1 : maxBitonic;
        }
        System.out.println("Length== " + maxBitonic);

    }

}

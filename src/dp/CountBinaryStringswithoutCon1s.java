package dp;

import java.util.Scanner;

public class CountBinaryStringswithoutCon1s
{

    /**
     * Given a positive integer N, count all possible distinct binary strings of length N such that there are no
     * consecutive 1’s.
     * 
     * Examples:
     * 
     * Input: N = 2 Output: 3 // The 3 strings are 00, 01, 10
     * 
     * Input: N = 3 Output: 5 // The 5 strings are 000, 001, 010, 100, 101
     * 
     * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
     * 
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        a[0] = 1;
        b[0] = 1;

        for (int i = 1; i < n; i++)
        {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        System.out.println(a[n - 1] + b[n - 1]);

    }

}

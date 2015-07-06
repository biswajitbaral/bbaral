package dp;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/unbounded-knapsack
 * 
 * Problem Statement

 Given a list of n integers, A={a1,a2,…,an}, and another integer, k representing the expected sum. Select zero or more numbers from A such that the sum of these numbers is as near as possible, but not exceeding, to the expected sum (k).

 Note

 Each element of A can be selected multiple times.
 If no element is selected then the sum is 0.
 Input Format

 The first line contains T the number of test cases. 
 Each test case comprises of two lines. First line contains two integers, n k, representing the length of list A and expected sum, respectively. Second line consists of n space separated integers, a1,a2,…,an, representing the elements of list A.

 Constraints 
 1≤T≤10 
 1≤n≤2000 
 1≤k≤2000 
 1≤ai≤2000,where i∈[1,n]
 Output Format

 Output T lines, the answer for each test case.

 Sample Input

 2
 3 12
 1 6 9
 5 9
 3 4 4 4 8
 */

public class Knapsack_H
{

    public static int findMax(int[] num, int eSum)
    {
        int len = num.length;
        int[][] data = new int[len][eSum + 1];

        for (int i = 0; i < len; i++)
        {

            for (int j = 1; j < eSum + 1; j++)
            {

                if (i == 0)
                {
                    data[i][j] = j - j % num[i];
                }
                else
                {
                    if (num[i] > j)
                    {
                        data[i][j] = data[i - 1][j];
                    }
                    else
                    {
                        data[i][j] = num[i] + Math.max(data[i - 1][j - num[i]], +data[i][j - num[i]]);
                    }
                }
                if (data[i][j] == eSum)
                {
                    return eSum;
                }

            }

        }

        return data[len - 1][eSum];
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0)
        {
            int n = in.nextInt();
            int[] nums = new int[n];
            int eSum = in.nextInt();
            for (int i = 0; i < n; i++)
            {
                nums[i] = in.nextInt();
            }
            System.out.println(findMax(nums, eSum));
        }

    }

}

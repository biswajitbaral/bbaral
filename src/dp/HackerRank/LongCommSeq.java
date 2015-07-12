package dp.HackerRank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence
public class LongCommSeq
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] ip1 = new int[n + 1];
        int[] ip2 = new int[m + 1];

        for (int i = 1; i <= n; i++)
        {
            ip1[i] = in.nextInt();
        }
        for (int i = 1; i <= m; i++)
        {
            ip2[i] = in.nextInt();
        }

        int[][] dp = new int[n + 1][m + 1];
        int i = 1, j = 1;
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= m; j++)
            {

                if (ip1[i] == ip2[j])
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }

        }
        i = n;
        j = m;
        int maxSub = dp[n][m];
        int[] result = new int[maxSub];
        int k = maxSub - 1;
        while (i > 0 && j > 0)
        {
            if (ip1[i] == ip2[j])
            {
                result[k] = ip1[i];
                k--;
                i--;
                j--;
            }
            else
            {
                if (dp[i - 1][j] > dp[i][j - 1])
                {
                    i--;
                }
                else
                {
                    j--;
                }

            }

        }
        for (k = 0; k < maxSub; k++)
        {
            System.out.print(result[k] + " ");
        }

    }

}

package HackerRank.CavityMap;

import java.util.Scanner;

public class Solution
{

    /**
     * https://www.hackerrank.com/challenges/cavity-map
     */

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), i, j;
        char c[][] = new char[n][];
        for (i = 0; i < n; i++)
        {
            c[i] = in.next().toCharArray();
        }
        for (i = 1; i < n - 1; i++)
        {
            for (j = 1; j < n - 1; j++)
            {
                if (c[i][j] > c[i][j - 1] && c[i][j] > c[i][j + 1] && c[i][j] > c[i - 1][j] && c[i][j] > c[i + 1][j])
                {
                    c[i][j] = 'X';
                }
            }
        }
        for (i = 0; i < n; i++)
        {
            System.out.println(new String(c[i]));
        }
    }

}

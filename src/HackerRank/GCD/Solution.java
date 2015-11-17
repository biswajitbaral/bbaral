package HackerRank.GCD;

import java.util.Scanner;

public class Solution
{

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-gcd
     */
    static long GCD(long a, long b)
    {
        while (a != b)
        {
            if (a > b)
            {
                a = a - b;
            }
            else
            {
                b = b - a;
            }
        }
        return a;

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();

        while (t-- > 0)
        {

            long n = in.nextLong();
            long[] ip = new long[(int) n];
            ip[0] = in.nextLong();
            long tmp = ip[0];
            for (int i = 1; i < n; i++)
            {
                ip[i] = in.nextLong();
                tmp = GCD(tmp, ip[i]);

            }
            if (tmp == 1)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }

        }

    }

}

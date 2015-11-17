package HackerRank.Search;

import java.util.Scanner;

public class MaxSum
{

    /**
     * https://www.hackerrank.com/challenges/maximise-sum
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        long t = in.nextLong();

        while (t-- > 0)
        {
            long n = in.nextLong();
            long m = in.nextLong();

            long[] ip = new long[(int) n];
            long sum = 0;
            long tmp = 0;
            for (long i = 0; i < n; i++)
            {
                ip[(int) i] = in.nextLong();

                if (tmp < (tmp + ip[(int) i]) % m)
                {
                    tmp = (tmp + ip[(int) i]) % m;
                }
                else
                {

                    if (sum < tmp)
                    {
                        sum = tmp;
                    }

                    tmp = 0;
                }
                if (sum == m - 1)
                {
                    break;
                }

            }
            System.out.println(sum);
        }
    }

}

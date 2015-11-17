package HackerRank.TomBday;

import java.util.Scanner;

public class Solution
{

    /**
     * https://www.hackerrank.com/challenges/taum-and-bday
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();

        while (t-- > 0)
        {

            long b = in.nextLong();
            long w = in.nextLong();

            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();

            long a1 = b * x + w * y;
            long a2 = b * (y + z) + w * y;
            long a3 = b * x + w * (x + z);
            System.out.println(Math.min(a1, Math.min(a2, a3)));
        }

    }

}

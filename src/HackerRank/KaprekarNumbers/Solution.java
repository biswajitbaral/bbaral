package HackerRank.KaprekarNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{

    /**
     * https://www.hackerrank.com/challenges/kaprekar-numbers
     */
    public static boolean ok(int i)
    {
        long sq = (long) i * (long) i;
        String s = String.valueOf(sq);
        String t = String.valueOf(i);
        int d = t.length();
        if (d == s.length())
        {
            return i == 1;
        }

        int b1 = Integer.parseInt(s.substring(0, s.length() - d));
        int b2 = Integer.parseInt(s.substring(s.length() - d));
        if (b2 == 0)
        {
            return false;
        }
        return b1 + b2 == i;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();

        ArrayList<Integer> sol = new ArrayList<Integer>();
        for (int i = p; i <= q; i++)
        {
            if (ok(i))
            {
                sol.add(i);
            }
        }
        if (sol.size() == 0)
        {
            System.out.println("INVALID RANGE");
        }
        else
        {
            for (int i = 0; i < sol.size(); i++)
            {
                if (i > 0)
                {
                    System.out.print(" ");
                }
                System.out.print(sol.get(i));
            }
            System.out.println();
        }

        System.exit(0);

    }

}

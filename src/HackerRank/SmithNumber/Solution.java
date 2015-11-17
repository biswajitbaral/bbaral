package HackerRank.SmithNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{

    /**
     * @param args
     */

    public static List<Long> primeFactors(long numbers)
    {
        long n = numbers;
        List<Long> factors = new ArrayList<Long>();
        for (long i = 2; i <= n / i; i++)
        {
            while (n % i == 0)
            {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1)
        {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        long sum = 0;
        long sum1 = 0;

        for (long i : primeFactors(t))
        {
            while (i != 0)
            {
                sum += i % 10;
                i = i / 10;
            }

        }

        while (t != 0)
        {
            sum1 += t % 10;
            t = t / 10;
        }
        if (sum == sum1)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }

    }

}

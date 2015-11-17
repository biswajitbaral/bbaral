package dp;

import java.math.BigInteger;

public class StaircaseFib
{

    /**
     * Staircase Problem Fibonacci Series
     * 
     * Input- if we can can at most 'N' steps at one time , then how many ways can complete to reach the Total number of
     * staircases.
     * 
     * e.g. -- if max staircase can go at one time is 2 , then no. of ways to go 5 stairs.
     * 
     * 1 1 1 1 1, 1 1 2 1 1 2 1 1 2 1 1 1 2 2 1 1 1 1 2 1 2 2 2 1 2
     * 
     * So total no of ways =8.
     * 
     * formulae-- if 'n' is no of staircase and k is the max no. of staircase can go at one time , then
     * 
     * To reach n -- F(n)=F(n-1)+F(n-2)+...+F(n-k)
     * 
     */
    public static int fibonacciSeries(int n)
    {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // https://www.hackerrank.com/challenges/fibonacci-modified

    public static BigInteger fibonacciSeries(int a, int b, long n)
    {

        BigInteger c = BigInteger.valueOf(1);
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);
        for (int i = 2; i < n; i++)
        {
            c = a1.add(b1.multiply(b1));
            a1 = b1;
            b1 = c;
            System.out.println(c);
        }
        return c;
    }

    public static void main(String[] args)
    {

        int steps = 2;

        System.out.println(fibonacciSeries(5));

        System.out.println(fibonacciSeries(0, 1, 10));

    }

}

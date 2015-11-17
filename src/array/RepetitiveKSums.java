package array;

import java.util.Arrays;
import java.util.Scanner;

public class RepetitiveKSums
{

    /**
     * @param args
     */
    // N c K-- total sums can be.
    public static long bin(long n, long k)
    {
        if (k > n - k)
        {
            k = n - k;
        }
        int p = 1;
        for (long i = 1; i <= k; ++i)
        {
            p *= n + 1 - i;
            p /= i;
        }
        return p;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        long t = in.nextLong();

        while (t-- > 0)
        {
            long N = in.nextLong();
            long k = in.nextLong();
            long len = bin(N + k - 1, k);
            long[] data = new long[(int) len];

            for (long i = 0; i < len; i++)
            {
                data[(int) i] = in.nextLong();
            }

            Arrays.sort(data);
            long[] result = new long[(int) N];
            result[0] = data[0] / k;
            System.out.print(result[0]);
            for (long i = 1; i < N; i++)
            {

                result[(int) i] = data[(int) i] - (k - 1) * result[0];
                System.out.print(" " + result[(int) i]);
            }
            System.out.println();

        }

    }

}

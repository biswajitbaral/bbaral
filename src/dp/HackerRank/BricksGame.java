package dp.HackerRank;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/play-game
 * 
 * You and your friend decide to play a game using a stack consisting of N bricks. In this game, you can alternatively remove 1, 2 or 3 bricks from the top, and the numbers etched on the removed bricks are added to your score. You have to play so that you obtain the maximum possible score. It is given that your friend will also play optimally and you make the first move.

 Input Format 
 First line will contain an integer T i.e. number of test cases. There will be two lines corresponding to each test case: first line will contain a number N i.e. number of elements in the stack and next line will contain N numbers i.e. numbers etched on bricks from top to bottom.

 Output Format 
 For each test case, print a single line containing your maximum score.

 Constraints 
 1 ≤ T ≤ 5 
 1 ≤ N ≤ 105 
 0 ≤ each number on brick ≤ 109

 Sample Input

 2
 5
 999 1 1 1 0
 5
 0 1 1 1 999
 Sample Output

 1001
 999
 Explanation

 In first test case, you will pick 999,1,1. If you play in any other way, you will not get a score of 1001. 
 In second case, best option will be to pick up the first brick (with 0 score) at first. Then your friend will choose the next three blocks, and you will get the last brick.
 */

public class BricksGame
{

    /**
     * @param args
     */

    public static long pickBrick(long[] ip, long len)
    {
        long[] sum = new long[(int) len];
        sum[0] = ip[0];
        for (int i = 1; i < len; i++)
        {

            sum[i] = sum[i - 1] + ip[i];
        }
        long[] data = new long[(int) len];

        data[0] = ip[0];
        data[1] = ip[0] + ip[1];
        data[2] = ip[0] + ip[1] + ip[2];

        // data[k]= ip[k]+sum[k-1]-dp[k-1] , ip[k]+ip[k-1]+sum[k-2]-dp[k-2],ip[k]+ip[k-1]+ip[k-2]+sum[k-1]-dp[k-3]

        for (int k = 3; k < len; k++)
        {

            data[k] = max(ip[k] + sum[k - 1] - data[k - 1], ip[k] + ip[k - 1] + sum[k - 2] - data[k - 2], ip[k]
                    + ip[k - 1] + ip[k - 2] + sum[k - 3] - data[k - 3]);
        }
        return data[(int) len - 1];
    }

    static long max(long l, long m, long n)
    {
        return (l > m ? l : m) > n ? (l > m ? l : m) : n;

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        long t = in.nextLong();
        while (t-- > 0)
        {
            long len = in.nextLong();

            long[] brk = new long[(int) len];
            for (long i = len - 1; i >= 0; i--)
            {

                brk[(int) i] = in.nextLong();
            }
            System.out.println(pickBrick(brk, len));
        }
    }

}

package dp.HackerRank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/string-reduction

public class StringReduction
{

    /**
     * @param args
     */
    static int stringReduction(String a)
    {
        char[] data = a.toCharArray();
        int[] res = new int[3];
        for (int i = 0; i < data.length; i++)
        {
            res[data[i] - 97]++;
        }
        int ans = 0;
        int x = (res[0] + res[1]) * (res[1] + res[2]) * (res[2] + res[0]);
        if (x == 0)
        {
            ans = a.length();
        }
        else if ((res[0] + res[1]) % 2 == 0 && (res[1] + res[2]) % 2 == 0 && (res[2] + res[0]) % 2 == 0)
        {
            ans = 2;
        }
        else
        {
            ans = 1;
        }

        return ans;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int res;

        int _t_cases = Integer.parseInt(in.nextLine());
        for (int _t_i = 0; _t_i < _t_cases; _t_i++)
        {
            String _a = in.nextLine();
            res = stringReduction(_a);
            System.out.println(res);
        }
    }
}

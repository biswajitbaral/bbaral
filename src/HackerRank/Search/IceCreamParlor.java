package HackerRank.Search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor
{

    /**
     * https://www.hackerrank.com/challenges/icecream-parlor
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0)
        {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] ip = new int[n];
            Map<Integer, Integer> data = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++)
            {
                ip[i] = in.hashCode();
                data.put(ip[i], i);
            }

            for (int i = 0; i < n; i++)
            {

                if (data.containsKey(m - ip[i]) && i < data.get(m - ip[i]))
                {
                    System.out.println(i + " " + data.get(m - ip[i]));
                }

            }

        }

    }

}

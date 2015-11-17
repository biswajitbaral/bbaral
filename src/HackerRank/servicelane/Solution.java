package HackerRank.servicelane;

import java.util.Scanner;

public class Solution
{

    /**
     * https://www.hackerrank.com/challenges/service-lane
     * 
     */
    static int findMin(int[] ip, int i, int j)
    {
        int tmp = ip[i];
        for (; i <= j; i++)
        {
            if (tmp > ip[i])
            {
                tmp = ip[i];
            }
        }
        return tmp;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String[] ip = in.nextLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int t = Integer.parseInt(ip[1]);

        int[] width = new int[n];
        int i = 0;

        for (String str : in.nextLine().split(" "))
        {
            width[i] = Integer.parseInt(str);
            i++;
        }
        while (t-- > 0)
        {
            String[] data = in.nextLine().split(" ");

            System.out.println(findMin(width, Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }

    }

}

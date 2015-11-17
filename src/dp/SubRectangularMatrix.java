package dp;

import java.util.Scanner;

/*
 * 
 * Mr K has a rectangular land of size m×n. There are marshes in the land where the fence cannot hold. Mr K wants you to find the perimeter of the largest rectangular fence that can be built on this land.

 Input format

 The first line contains m and n. The next m lines contain n characters each describing the state of the land. 'x' (ascii value: 120) if it is a marsh and '.' ( ascii value:46) otherwise.

 Constraints

 2≤m,nle500
 Output Format

 Output contains a single integer - the largest perimeter. If the rectangular fence cannot be built, print "impossible" (without quotes).
 */
class var
{
    int row;
    int col;
}

public class SubRectangularMatrix
{

    public static int maxPerimetreRect(char[][] input)
    {
        int rw = input.length;
        int cl = input[0].length;

        var[][] vr = new var[rw + 1][cl + 1];

        for (int i = 0; i <= rw; i++)
        {
            for (int j = 0; j <= cl; j++)
            {
                vr[i][j] = new var();
            }
        }

        for (int i = 1; i <= rw; i++)
        {

            for (int j = 1; j <= cl; j++)
            {

                if (input[i - 1][j - 1] == '.')
                {
                    vr[i][j].col = vr[i][j - 1].col + 1;
                    vr[i][j].row = vr[i - 1][j].row + 1;
                }

            }
        }

        for (int i = 0; i <= rw; i++)
        {
            for (int j = 0; j <= cl; j++)
            {
                System.out.print(vr[i][j].row + "," + vr[i][j].col + "  ");
            }
            System.out.println();
        }
        int max = 0;
        for (int i = 1; i <= rw; i++)
        {
            for (int j = 1; j <= cl; j++)
            {

                int r = vr[i][j].row;
                int c = vr[i][j].col;

                if (per > max)
                {
                    System.out.println(i + "," + j);
                    System.out.println(row + "," + col);
                    System.out.println(vr[i][j].row + "," + vr[i][j].col + "  ");
                    max = per;
                }

            }

        }
        return max;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int rw = Integer.parseInt(in.next());
        int cl = Integer.parseInt(in.next());

        char[][] ip = new char[rw][cl];

        for (int i = 0; i < rw; i++)
        {
            ip[i] = in.next().toCharArray();
        }

        int maxPer = maxPerimetreRect(ip);
        if (maxPer == 0)
        {
            System.out.println("impossible");
        }
        else
        {
            System.out.println(maxPer);
        }
    }

}

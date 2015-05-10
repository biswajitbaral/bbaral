package dp;

import java.util.Stack;

public class MinCostPath
{

    /**
     * In Given Matrix min cost to travel from ist element to last element.
     * 
     * Only moves toward right or down are allowed.
     * 
     */
    private static int minCostToTravel(int[][] input, int length, int height)
    {
        Stack<Integer> showPath = new Stack<Integer>();

        int[][] data = new int[height + 1][length + 1];
        int i, j = 0;
        for (i = 1; i <= height; i++)
        {
            for (j = 1; j <= length; j++)
            {
                if (i == 1 && j == 1)
                {
                    data[i][j] = input[i - 1][j - 1];
                }
                else if (i == 1)
                {
                    data[i][j] = data[i][j - 1] + input[i - 1][j - 1];
                }
                else if (j == 1)
                {
                    data[i][j] = data[i - 1][j] + input[i - 1][j - 1];
                }
                else
                {

                    data[i][j] = input[i - 1][j - 1] + Math.min(data[i - 1][j], data[i][j - 1]);

                }

            }

        }
        i--;
        j--;

        while (i >= 1 && j >= 1)
        {

            if (i == 1 && j > 1)
            {
                showPath.push(data[i][j] - data[i][j - 1]);
                j--;
            }
            else if (j == 1 && i > 1)
            {
                showPath.push(data[i][j] - data[i - 1][j]);
                i--;
            }

            else if (data[i][j - 1] < data[i - 1][j])
            {
                showPath.push(data[i][j] - data[i][j - 1]);
                j--;
            }
            else
            {
                showPath.push(data[i][j] - data[i - 1][j]);
                i--;
            }

        }
        System.out.println("path==" + showPath);

        return data[height][length];
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[][] input =
        {
        { 1, 3, 5, 8 },
        { 4, 2, 1, 7 },
        { 4, 3, 2, 3 } };
        int cost = minCostToTravel(input, 4, 3);
        System.out.println(cost);
    }

}

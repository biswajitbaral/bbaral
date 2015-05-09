package dp;

public class Knapsack
{

    /**
     * Weights w1 w2 w3 w4 value v1 v2 v3 v4
     * 
     * W - 2 3 4 5 v - 3 4 5 6
     * 
     * for sum=5 , max value = 7
     * 
     */
    public static int calMaxValue(int[] wt, int[] val, int maxWt)
    {
        int[][] data = new int[wt.length + 1][maxWt + 1];

        for (int i = 1; i <= wt.length; i++)
        {

            for (int j = 1; j <= maxWt; j++)
            {
                if (j >= wt[i - 1])
                {
                    data[i][j] = Math.max(data[i - 1][j], val[i - 1] + data[i - 1][j - wt[i - 1]]);

                }
                else
                {

                    data[i][j] = data[i - 1][j];
                }
            }

        }

        return data[wt.length][maxWt];
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] wt =
        { 2, 3, 4, 5 };
        int[] val =
        { 3, 4, 5, 6 };
        int maxWt = 5;
        System.out.println(calMaxValue(wt, val, maxWt));

    }

}

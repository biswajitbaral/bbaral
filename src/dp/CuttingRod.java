package dp;

public class CuttingRod
{

    /**
     * Cutting Rod To Manage Proffit Length Price 
     * 1 > 2
     * 2 > 5 
     * 3 > 7 
     * 4 > 8
     * 
     * Have to cut in total length =5 , so that it will give maximum price.
     * 
     * here for length =5 , max price= 12 (can be cut into 1+2+2).
     * 
     */
    public static int calMaxProfit(int[] lt, int[] price, int totLen)
    {

        int[][] data = new int[lt.length + 1][totLen + 1];

        for (int i = 1; i <= lt.length; i++)
        {
            for (int j = 1; j <= totLen; j++)
            {
                if (j >= lt[i - 1])
                {
                    data[i][j] = Math.max(data[i - 1][j], price[i - 1] + data[i][j - lt[i - 1]]);
                }
                else
                {
                    data[i][j] = data[i - 1][j];
                }

            }

        }

        return data[lt.length][totLen];
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        int[] length =
        { 1, 2, 3, 4 };
        int[] price =
        { 2, 5, 7, 8 };
        int totLen = 5;

        int maxPrice = calMaxProfit(length, price, totLen);

        System.out.println(maxPrice);

    }

}

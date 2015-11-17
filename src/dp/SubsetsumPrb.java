package dp;

public class SubsetsumPrb
{

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem
     */
    public static boolean ChecksubsetSum(int[] num, int sum)
    {

        int len = num.length;

        int tmpsum = 0;
        for (Integer i : num)
        {
            tmpsum += i;
        }
        if (tmpsum < sum)
        {
            return false;
        }
        boolean[][] data = new boolean[len][sum + 1];
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < sum + 1; j++)
            {
                if (j == 0)
                {
                    data[i][j] = true;
                }
                else if (i == 0)
                {
                    data[i][j] = (num[i] == j ? true : false);
                }
                else
                {
                    if (j < num[i])
                    {
                        data[i][j] = data[i - 1][j];
                    }
                    else
                    {
                        data[i][j] = (data[i - 1][j - num[i]] || data[i - 1][j]);
                    }

                }

            }

        }

        if (data[len - 1][sum])
        {
            int i = len - 1;

            while (i > 0)
            {
                if (data[i - 1][sum])
                {
                    i--;
                }
                else
                {
                    System.out.println(num[i]);
                    sum = sum - num[i];
                }
            }

        }

        return data[len - 1][sum];
    }

    public static void main(String[] args)
    {
        int[] num =
        { 2, 3, 7, 8, 10 };
        int sum = 11;

        System.out.println(ChecksubsetSum(num, sum));
    }

}

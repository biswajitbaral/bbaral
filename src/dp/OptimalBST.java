package dp;

public class OptimalBST
{

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
     */

    public static int OptimalSearchTree(int[] input, int[] freq)
    {

        int len = input.length;
        int[][] data = new int[len][len];

        for (int i = 0; i < len; i++)
        {
            data[i][i] = freq[i];
        }

        for (int t = 2; t <= len; t++)
        {

            for (int i = 0; i < len - t + 1; i++)
            {
                int j = i + t - 1;
                data[i][j] = Integer.MAX_VALUE;
                int sum = sum(freq, i, j);
                for (int k = i; k <= j; k++)
                {
                    int c = sum + (k > i ? data[i][k - 1] : 0) + (k < j ? data[k + 1][j] : 0);
                    if (c < data[i][j])
                    {
                        data[i][j] = c;
                    }

                }

            }
        }

        return data[0][len - 1];

    }

    static int sum(int freq[], int i, int j)
    {
        int s = 0;
        for (int k = i; k <= j; k++)
        {
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args)
    {
        int[] input =
        { 10, 12, 16, 21 };
        int[] freq =
        { 4, 2, 6, 3 };
        System.out.println(OptimalSearchTree(input, freq));

    }

}

package dp;

public class MaxSubSquareMatrix
{

    /**
     * Given a matrix where every element is either ‘0’ or ‘1’, find the largest subsquare surrounded by ‘1’.
     * 
     * In the below article, it is assumed that the given matrix is also square matrix. The code given below can be
     * easily extended for rectangular matrices.
     * 
     * Examples:
     * 
     * Input: mat[N][N] = { {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 0, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 0, 0}, };
     * Output: 3
     * 
     */
    private static int maxSubSqMatrix(int[][] ip, int row, int col)
    {
        int[][] data = new int[row + 1][col + 1];
        int maxSub = 0;

        for (int i = 1; i <= row; i++)
        {
            for (int j = 1; j <= col; j++)
            {
                if (ip[i - 1][j - 1] == 0)
                {
                    data[i][j] = 0;
                }
                else
                {
                    int min = ip[i - 1][j - 1] + smallestNum(data[i - 1][j], data[i][j - 1], data[i - 1][j - 1]);
                    data[i][j] = min;
                    maxSub = (min < maxSub ? maxSub : min);
                }

            }
        }

        return maxSub;
    }

    static int smallestNum(int a, int b, int c)
    {
        return (a < ((b < c) ? b : c)) ? a : ((b < c) ? b : c);
    }

    public static void main(String[] args)
    {

        int mat[][] =
        {
        { 0, 0, 1, 1, 1 },
        { 1, 0, 1, 1, 1 },
        { 1, 1, 1, 1, 1 },
        { 1, 0, 1, 1, 1 },
        { 1, 1, 1, 0, 0 }, };

        int maxSub = maxSubSqMatrix(mat, 5, 5);
        System.out.println(maxSub);

    }

}

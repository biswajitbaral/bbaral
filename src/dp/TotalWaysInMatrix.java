package dp;

public class TotalWaysInMatrix
{

    /**
     * total no of ways to travel from start to end in a matrix.
     */
    private static int calNoOfways(int[][] input, int row, int column)
    {

        int[][] data = new int[row][column];
        for (int i = 0; i < row; i++)
        {

            for (int j = 0; j < column; j++)
            {
                if (i == 0 || j == 0)
                {
                    data[i][j] = 1;
                }
                else
                {
                    data[i][j] = data[i - 1][j] + data[i][j - 1];
                }

            }
        }
        return data[row - 1][column - 1];
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[][] input =
        {
        { 1, 3, 5, 8 },
        { 4, 2, 1, 7 },
        { 4, 3, 2, 3 } };

        int totalways = calNoOfways(input, 3, 4);
        System.out.println(totalways);
    }

}

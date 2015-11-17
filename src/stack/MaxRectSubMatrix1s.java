package stack;

public class MaxRectSubMatrix1s
{

    /**
     * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s in this matrix
     */
    public static int maxRect(int[][] arr)
    {

        int row = arr.length;
        int col = arr[0].length;

        int[] data = new int[col];
        int maxarea = 0;
        for (int i = 0; i < row; i++)
        {

            for (int j = 0; j < col; j++)
            {
                if (arr[i][j] == 0)
                {
                    data[j] = 0;
                }
                else
                {
                    data[j] += arr[i][j];
                }
            }
            int tmp = MaxHistogramArea.maxArea(data);
            if (tmp > maxarea)
            {
                maxarea = tmp;
            }

        }
        return maxarea;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        int[][] arr =
        {
        { 1, 0, 0, 1, 1, 1 },
        { 1, 0, 1, 1, 0, 1 },
        { 0, 1, 1, 1, 1, 1 },
        { 0, 0, 1, 1, 1, 1 } };

        int max = maxRect(arr);
        System.out.println(max);

    }

}

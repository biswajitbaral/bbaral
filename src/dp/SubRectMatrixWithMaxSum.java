package dp;

public class SubRectMatrixWithMaxSum
{

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix
     */
    class Result
    {
        int maxSum;
        int maxLeft;
        int maxRight;
        int maxUp;
        int maxDown;

        @Override
        public String toString()
        {
            return "Result [maxSum=" + maxSum + ", maxLeft=" + maxLeft + ", maxRight=" + maxRight + ", maxUp=" + maxUp
                    + ", maxDown=" + maxDown + "]";
        }
    }

    public Result findMatrixDetails(int[][] input)
    {
        int rows = input.length;
        int cols = input[0].length;

        int[] tmp = new int[rows];

        Result r = new Result();

        Kadane k = new Kadane();
        for (int left = 0; left < cols; left++)
        {
            for (int i = 0; i < rows; i++)
            {
                tmp[i] = 0;
            }

            for (int right = left; right < cols; right++)
            {
                for (int i = 0; i < rows; i++)
                {
                    tmp[i] += input[i][right];
                }
                k = k.findMaxsumSubseq(tmp);
                if (k.maxSum > r.maxSum)
                {
                    r.maxSum = k.maxSum;
                    r.maxUp = k.start;
                    r.maxDown = k.end;
                    r.maxLeft = left;
                    r.maxRight = right;
                }

            }

        }
        return r;

    }

    public static void main(String[] args)
    {
        int input[][] =
        {
        { 2, 1, -3, -4, 5 },
        { 0, 6, 3, 4, 1 },
        { 2, -2, -1, 4, -5 },
        { -3, 3, 1, 0, 3 } };

        SubRectMatrixWithMaxSum sb = new SubRectMatrixWithMaxSum();
        System.out.println(sb.findMatrixDetails(input));
    }

}

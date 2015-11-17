package dp;

/*
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

 We have many options to multiply a chain of matrices because matrix multiplication is associative. In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:

 (ABC)D = (AB)(CD) = A(BCD) = ....
 However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,

 (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
 A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 Clearly the first parenthesization requires less number of operations.
 */
public class MatrixMulCost
{

    public static int findMatrixMulCost(int[] arr)
    {

        int len = arr.length;
        int[][] cost = new int[len][len];

        for (int i = 1; i < len; i++)
        {
            cost[i][i] = 0;
        }
        for (int l = 2; l < len; l++)
        {

            for (int i = 1; i < len - l + 1; i++)
            {

                int j = i + l - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++)
                {
                    int tmp = cost[i][k] + cost[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (tmp < cost[i][j])
                    {
                        cost[i][j] = tmp;
                    }
                }

            }

        }

        return cost[1][len - 1];
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 2, 3, 6, 4, 5 };

        // here matrixes are [2,3][3,6][6,4][4,5]

        int minCost = findMatrixMulCost(arr);
        System.out.println("Min cost = " + minCost);
    }

}

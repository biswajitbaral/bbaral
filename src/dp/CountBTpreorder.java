package dp;

/**
 * Given a preorder sequence how many unique trees can be created Solution is catalan number. Number of tree is exactly
 * same as number of unique BST create with array of size n
 */
public class CountBTpreorder
{

    public static int totalBinaryTree(int[] ip)
    {

        int len = ip.length;

        if (len == 0)
        {
            return 0;
        }

        int[] data = new int[len + 1];

        data[0] = 1;
        data[1] = 1;

        for (int l = 2; l <= len; l++)
        {

            int sum = 0;

            for (int i = 0; i < l; i++)
            {
                sum += data[i] * data[l - i - 1];
            }
            data[l] = sum;
        }

        return data[len];
    }

    public static void main(String[] args)
    {
        int[] preOrderSeq =
        { 10, 11, 9, 12, 13, 14 };

        int totalBT = totalBinaryTree(preOrderSeq);

        System.out.println("Total = " + totalBT);

    }

}

package dp;

/*
 * http://www.geeksforgeeks.org/program-nth-catalan-number/
 */
public class CountBST
{
    public static int totalBinarySearchTree(int len)
    {

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
        System.out.println(totalBinarySearchTree(5));

    }

}

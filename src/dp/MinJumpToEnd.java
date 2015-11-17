package dp;

public class MinJumpToEnd
{

    /**
     * Given an array, find minimum number to jumps to reach end of array, given you can jump at max as much as value at
     * position in array.
     */
    private static int calMinJump(int[] arr, int[] result)
    {
        int len = arr.length;

        int[] jump = new int[arr.length];

        for (int i = 1; i < len; i++)
        {

            for (int j = 0; j < i; j++)
            {
                // System.out.println("i = " + i + " j = " + j + " arr[" + j + "] = " + arr[j]);
                if ((i - j) <= arr[j])
                {
                    if (jump[i] == 0)
                    {
                        jump[i] = jump[j] + 1;
                        result[i] = j;
                    }

                    else if (jump[i] > (jump[j] + 1))
                    {
                        jump[i] = jump[j] + 1;
                        result[i] = j;
                    }

                }

            }

        }

        return jump[arr.length - 1];
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
        int[] ret = new int[arr.length];
        System.out.println("Min Jump == " + calMinJump(arr, ret));

        int i = arr.length - 1;
        while (i > 0)
        {
            System.out.println(ret[i]);
            i = ret[i];
        }
    }

}

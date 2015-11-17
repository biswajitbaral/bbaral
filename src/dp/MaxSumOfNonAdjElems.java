package dp;

public class MaxSumOfNonAdjElems
{

    /**
     * @param args
     */
    public static int maxSumOfNonAdj(int[] ip)
    {

        int maxIncl = ip[0];
        int maxExcl = 0;

        int sum = 0;
        for (int i = 1; i < ip.length; i++)
        {
            int tmp = maxIncl;
            maxIncl = Math.max(maxIncl, maxExcl + ip[i]);
            maxExcl = tmp;
        }
        return maxIncl;
    }

    public static void main(String[] args)
    {
        int[] ip =
        { 4, 1, 1, 4, 2, 1 };

        System.out.println(maxSumOfNonAdj(ip));
    }

}

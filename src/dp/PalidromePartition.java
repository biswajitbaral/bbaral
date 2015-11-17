package dp;

/*
 *  Given a string , we have to find out how many min splits can be made so that each part can be a pallidrome string.
 *  
 *  e.g. -- input-- abcbm  , this can be splilted into a-bcb-m so that each string is pallindromic.
 *  
 *  so , here minimum splits made is  2.
 * /
 */
public class PalidromePartition
{

    public static int minSplitForpalindrom(String ip)
    {

        int len = ip.length();

        int[][] spt = new int[len][len];

        for (int i = 0; i < len; i++)
        {
            spt[i][i] = 0;
        }

        for (int l = 2; l <= len; l++)
        {

            for (int i = 0; i < len - l + 1; i++)
            {
                int k = i + l - 1;
                String str = ip.substring(i, k + 1);
                if (isPallindrome(str))
                {
                    spt[i][k] = 0;
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    for (int j = i; j < k; j++)
                    {
                        int tmp = 1 + spt[i][j] + spt[j + 1][k];
                        if (tmp < min)
                        {
                            min = tmp;
                        }
                    }
                    spt[i][k] = min;
                }
            }
        }

        return spt[0][len - 1];
    }

    public static boolean isPallindrome(String str)
    {

        int i = str.length() - 1;
        int j = 0;
        while (i > j)
        {
            if (str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String str = "abcbm";

        System.out.println(minSplitForpalindrom(str));
    }

}

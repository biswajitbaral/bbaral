package dp;

public class LcSubstring
{

    /**
     * Given two strings, find longest common substring between them.
     */
    private static int LcSubstring(String str1, String str2)
    {

        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        int[][] data = new int[chr2.length + 1][chr1.length + 1];

        int minLen = 0;

        for (int i = 1; i <= chr2.length; i++)
        {
            for (int j = 1; j <= chr1.length; j++)
            {
                if (chr2[i - 1] == chr1[j - 1])
                {
                    data[i][j] = 1 + data[i - 1][j - 1];
                    minLen = minLen < data[i][j] ? data[i][j] : minLen;
                }
                else
                {
                    data[i][j] = 0;
                }
            }

        }
        return minLen;
    }

    public static void main(String[] args)
    {
        String str1 = "abcdef";
        String str2 = "lbcdk";
        int len = LcSubstring(str1, str2);
        System.out.println(len);

    }

}

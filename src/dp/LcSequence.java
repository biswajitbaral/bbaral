package dp;

public class LcSequence
{

    /**
     * @param args
     */
    private static int LcSequence(String str1, String str2)
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

                }
                else
                {
                    data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);
                }
            }

        }
        return data[chr2.length][chr2.length];
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String str1 = "APBCADCQER";
        String str2 = "RASBTAVCVE";
        int maxSeq = LcSequence(str1, str2);
        System.out.println(maxSeq);

    }

}

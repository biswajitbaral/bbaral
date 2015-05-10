package dp;

public class MinEditString
{

    /**
     * Given two strings and operations edit, delete and add, how many minimum operations would it take to convert one
     * string to another string.
     */
    private static int minEditString(String str1, String str2)
    {
        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        int[][] data = new int[chr2.length + 1][chr1.length + 1];

        for (int i = 0; i <= chr2.length; i++)
        {
            for (int j = 0; j <= chr1.length; j++)
            {
                if (i == 0 && j == 0)
                {
                    data[i][j] = 0;
                }

                else if (i == 0 && j != 0)
                {
                    data[i][j] = data[i][j - 1] + 1;
                }
                else if (j == 0 && i != 0)
                {
                    data[i][j] = data[i - 1][j] + 1;
                }
                else
                {
                    if (chr1[j - 1] == chr2[i - 1])
                    {
                        data[i][j] = data[i - 1][j - 1];
                    }
                    else
                    {
                        data[i][j] = 1 + smallestNum(data[i - 1][j - 1], data[i - 1][j], data[i][j - 1]);
                    }

                }

            }

        }

        return data[chr2.length][chr1.length];

    }

    static int smallestNum(int a, int b, int c)
    {
        return (a < ((b < c) ? b : c)) ? a : ((b < c) ? b : c);
    }

    public static void main(String[] args)
    {
        String str1 = "abcdef";
        String str2 = "alcdp";
        // TODO Auto-generated method stub
        int minEdit = minEditString(str1, str2);
        System.out.println(minEdit);

    }

}

package dp;

/*
 *  ip--
 *     1> a a b
 *     2> a x y
 *     3>a a x a b y  -- return true
 *     
 *     
 *      Sting interleaving means to check if the third string is combination of 1st and second with actual order.
 *       
 *   http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2 
 * 
 */
public class StringInterleaving
{

    public static boolean checkStrInterleaving(String str1, String str2, String str3)
    {

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] ch3 = str3.toCharArray();
        int col = str1.length() + 1;
        int row = str2.length() + 1;

        if (ch3.length != (ch2.length + ch1.length))
        {
            return false;
        }

        boolean[][] data = new boolean[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                int l = i + j - 1;
                if (i == 0 && j == 0)
                {
                    data[i][j] = true;
                }
                else if (i == 0)
                {

                    if (ch3[l] == ch1[j - 1])
                    {
                        data[i][j] = data[i][j - 1];
                    }
                }
                else if (j == 0)
                {
                    if (ch3[l] == ch2[i - 1])
                    {
                        data[i][j] = data[i - 1][j];
                    }
                }
                else
                {
                    data[i][j] = (ch1[j - 1] == ch3[l] ? data[i][j - 1]
                            : false || ch2[i - 1] == ch3[l] ? data[i - 1][j] : false);
                }

            }
        }
        return data[row - 1][col - 1];
    }

    public static void main(String[] args)
    {
        String str1 = "aab";
        String str2 = "axy";
        String str3 = "aaxaby";

        System.out.println(checkStrInterleaving(str1, str2, str3));

    }

}

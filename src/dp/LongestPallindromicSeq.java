package dp;

public class LongestPallindromicSeq
{

    public static int[][] lps(char[] str)
    {
        int n = str.length;
        int i, j;
        int L[][] = new int[n][n];
        // a s b d b a
        for (i = 0; i < n; i++)
        {
            L[i][i] = 1;
        }
        for (int c = 2; c <= n; c++)
        {

            for (i = 0; i < n - c + 1; i++)
            {
                j = i + c - 1;
                if (str[i] == str[j] && c == 2)
                {
                    L[i][j] = 2;
                }
                else if (str[i] == str[j])
                {
                    L[i][j] = L[i + 1][j - 1] + 2;
                }
                else
                {
                    L[i][j] = Math.max(L[i + 1][j], L[i][j - 1]);
                }

            }

        }
        return L;
    }

    // a s b d b a
    public static int LpsRecursive(char str[], int start, int len)
    {

        if (len == 1)
        {
            return 1;
        }
        if (len == 0)
        {
            return 0;
        }
        if (str[start] == str[start + len - 1])
        {
            return (2 + LpsRecursive(str, start + 1, len - 2));
        }
        else
        {
            return Math.max(LpsRecursive(str, start + 1, len - 1), LpsRecursive(str, start, len - 1));
        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        String s = "casdbda";
        int[][] matrix = lps(s.toCharArray());
        int subLength = matrix[0][s.length() - 1];
        System.out.println("Length of longest Subsequence =" + subLength);
        char[] data = new char[subLength];
        int i = 0, j = s.length() - 1;
        int k = 0;
        while (i <= j)
        {
            if (matrix[i][j - 1] == matrix[i + 1][j])
            {
                if (matrix[i + 1][j - 1] != matrix[i][j])
                {
                    data[k] = s.toCharArray()[i];
                    data[subLength - k - 1] = s.toCharArray()[i];
                    k++;
                }
                i++;
                j--;
            }
            else
            {
                if (matrix[i][j - 1] > matrix[i + 1][j])
                {
                    j--;
                }
                else
                {

                    i++;
                }

            }

        }
        System.out.println("Lcs ==" + data);
        // using recursive
        System.out.println(LpsRecursive(s.toCharArray(), 0, s.length()));

    }

}

package dp;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string and a dictionary, split this string into multiple words such that
 * each word belongs in dictionary.
 * 
 * Iplayliketo > I like to play
 * 
 */

public class WordBreak
{

    /**
     * @param args
     */

    public static String wordBreak(String str, Set<String> dt)
    {
        int[][] T = new int[str.length()][str.length()];

        for (int i = 0; i < T.length; i++)
        {
            for (int j = 0; j < T[i].length; j++)
            {
                T[i][j] = -1; // -1 indicates string between i to j cannot be split
            }
        }

        // check for one character to all characters
        for (int l = 1; l <= str.length(); l++)
        {

            for (int i = 0; i < str.length() - l + 1; i++)
            {
                int j = i + l - 1;

                String tmp = str.substring(i, j + 1);

                if (dt.contains(tmp))
                {
                    T[i][j] = i;
                    continue;
                }
                for (int k = i + 1; k <= j; k++)
                {

                    if (T[i][k - 1] != -1 && T[k][j] != -1)
                    {
                        T[i][j] = k;
                        break;
                    }
                }

            }

        }

        if (T[0][str.length() - 1] == -1)
        {
            return null;
        }

        // create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        int j = str.length() - 1;
        while (i < j)
        {
            int k = T[i][j];
            if (i == k)
            {
                buffer.append(str.substring(i, j + 1));
                break;
            }
            buffer.append(str.substring(i, k) + " ");
            i = k;
        }

        return buffer.toString();
    }

    public static void main(String[] args)
    {
        Set<String> dct = new HashSet<String>();
        dct.add("a");
        dct.add("I");
        dct.add("like");
        dct.add("to");
        dct.add("play");
        String str = "Iplayliketo";

        System.out.println(wordBreak(str, dct));

    }

}

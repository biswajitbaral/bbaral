package dp;

public class textJustification
{

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap
     */
    public static String TextJustification(String[] arr, int width)
    {
        int len = arr.length;
        // create array with sizes of the words present.

        int[] ip = new int[len];
        for (int a = 0; a < len; a++)
        {
            ip[a] = arr[a].length();
        }

        // extras[i][j] will have number of extra spaces if words from i to j are put in a single line

        int[][] extra = new int[len][width];

        int i, j;
        for (i = 0; i < len; i++)
        {
            extra[i][i] = width - ip[i];
            for (j = i + 1; j < len; j++)
            {
                extra[i][j] = extra[i][j - 1] - ip[j] - 1;
            }

        }

        // We can not find the exact space justification difference from extra spaces, for that we will create a cost
        // corresponding to the calculated extra by putting square value.
        int INF = Integer.MAX_VALUE;

        int[][] cost = new int[len][width];

        for (i = 0; i < len; i++)
        {

            for (j = i; j < len; j++)
            {
                if (extra[i][j] < 0)
                {
                    cost[i][j] = INF;
                }
                else
                {
                    cost[i][j] = extra[i][j] * extra[i][j];
                }

            }
        }

        int[] minCost = new int[len];

        int[] result = new int[len];

        for (i = len - 1; i >= 0; i--)
        {
            minCost[i] = cost[i][len - 1];
            result[i] = len;
            for (j = len - 1; j > i; j--)
            {
                if (cost[i][j - 1] == Integer.MAX_VALUE)
                {
                    continue;
                }

                if (minCost[i] > minCost[j] + cost[i][j - 1])
                {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    result[i] = j;
                }

            }
        }

        System.out.println("Minimum cost is " + minCost[0]);
        System.out.println("\n");
        // finally put all words with new line added in
        // string buffer and print it.
        i = 0;
        StringBuilder builder = new StringBuilder();
        do
        {
            j = result[i];
            for (int k = i; k < j; k++)
            {
                builder.append(arr[k] + " ");
            }
            builder.append("\n");
            i = j;
        } while (j < arr.length);

        System.out.println(builder);
        return builder.toString();

    }

    public static void main(String[] args)
    {
        String[] arr =
        { "Biswajit", "Baral", "likes", "to", "code" };

        TextJustification(arr, 12);

    }

}

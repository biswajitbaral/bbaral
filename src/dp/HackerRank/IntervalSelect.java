package dp.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

class Interval implements Comparable<Interval>
{
    int value;
    int start;
    int end;
    int count;

    public Interval(int val, int count, int st, int end)
    {
        this.value = val;
        this.count = count;
        this.start = st;
        this.end = end;
    }

    public Interval()
    {
    }

    @Override
    public int compareTo(Interval in)
    {
        if (this.start <= in.start && this.end <= in.end)
        {
            return -1;
        }
        else
        {
            return 1;
        }

    }

    @Override
    public String toString()
    {
        return "[" + value + ", " + count + ", " + start + ", " + end + "]";
    }

}

public class IntervalSelect
{

    /**
     * @param args
     */
    public static int maxInterval(Interval[] input)
    {

        int N = input.length;

        Interval[][] data = new Interval[N + 1][N + 1];

        for (int i = 0; i <= N; i++)
        {
            for (int j = 0; j <= N; j++)
            {
                if (i == j && i > 0)
                {
                    data[i][j] = new Interval(1, 1, input[i - 1].start, input[i - 1].end);
                }
                else
                {
                    data[i][j] = new Interval();
                }
            }
        }

        for (int i = 2; i <= N; i++)
        {
            for (int j = 1; j <= N - i + 1; j++)
            {

                int k = j + i - 1;
                if (data[j][j].end >= data[j + 1][k].start)
                {
                    if (data[j][j].count + data[j + 1][k].count >= 3)
                    {

                        data[j][k] = data[j + 1][k];

                    }
                    else
                    {
                        data[j][k].value = data[j][j].value + data[j + 1][k].value;
                        data[j][k].count = data[j][j].count + data[j + 1][k].count;
                        data[j][k].start = Math.max(data[j][j].start, data[j + 1][k].start);
                        data[j][k].end = Math.min(data[j][j].end, data[j + 1][k].end);
                    }
                }
                else
                {

                    data[j][k].value = data[j][j].value + data[j + 1][k].value;
                    data[j][k].count = 1;
                    data[j][k].start = Math.min(data[j][j].start, data[j + 1][k].start);
                    data[j][k].end = Math.max(data[j][j].end, data[j + 1][k].end);

                }

                /*
                 * if (data[j][k - 1].value == 0 || data[j + 1][k].value == 0) { if (data[j][k - 1].value == 0) {
                 * data[j][k] = data[j][k - 1]; } else { data[j][k] = data[j + 1][k]; }
                 * 
                 * } else if (data[j][k - 1].end < data[j + 1][k].start) { data[j][k].value = 1 + (Math.max(data[j][k -
                 * 1].value, data[j + 1][k].value)); data[j][k].start = data[j + 1][k].start; data[j][k].end = data[j +
                 * 1][k].end; } else { if (data[j][k - 1].end >= data[j + 1][k].start && data[j][k - 1].value + data[j +
                 * 1][k].value <= 2) { data[j][k].value = data[j][k - 1].value + data[j + 1][k].value; data[j][k].start
                 * = Math.max(data[j][k - 1].start, data[j + 1][k].start); data[j][k].end = Math.min(data[j][k - 1].end,
                 * data[j + 1][k].end); } else { data[j][k] = new Interval(0, 0, 0);
                 * 
                 * }
                 * 
                 * }
                 */

                /*
                 * if (data[j][k - 1].value == data[j + 1][k].value) {
                 * 
                 * if (data[j][k - 1].end < data[j + 1][k].start) { data[j][k].value = 1 + data[j + 1][k].value;
                 * data[j][k].start = 0; data[j][k].end = 0; } else { data[j][k].value = data[j][k - 1].value + data[j +
                 * 1][k].value; if (k - 1 == j + 1) { data[j][k].value = data[j][k].value - 1; } data[j][k].start =
                 * Math.max(data[j][k - 1].start, data[j + 1][k].start); data[j][k].end = Math.min(data[j][k - 1].end,
                 * data[j + 1][k].end); }
                 * 
                 * } else { if (data[j][k - 1].value < data[j + 1][k].value) { data[j][k] = data[j + 1][k]; } else {
                 * data[j][k] = data[j][k - 1]; }
                 * 
                 * }
                 */

            }

        }

        for (int i = 0; i <= N; i++)
        {
            for (int j = 0; j <= N; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

        return data[1][N].value;

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0)
        {
            int N = in.nextInt();
            Interval[] input = new Interval[N];
            for (int i = 0; i < N; i++)
            {
                int start = in.nextInt();
                int end = in.nextInt();
                input[i] = new Interval(0, 0, start, end);
            }
            Arrays.sort(input);
            System.out.println(maxInterval(input));
        }

    }

}

package dp;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDroping
{

    /**
     * @param args
     */
    public static int minEggDrop(int flr, int egg)
    {

        int data[][] = new int[egg + 1][flr + 1];

        for (int i = 1; i <= flr; i++)
        {
            data[1][i] = i;
        }
        for (int j = 2; j <= egg; j++)
        {

            for (int i = 1; i <= flr; i++)
            {

                if (j > i)
                {
                    data[j][i] = data[j - 1][i];
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    for (int k = 1; k <= i; k++)
                    {
                        int tmp = 1 + Math.max(data[j - 1][k - 1], data[j][i - k]);
                        if (tmp < min)
                        {
                            min = tmp;
                        }

                    }
                    data[j][i] = min;

                }
            }

        }
        return data[egg][flr];
    }

    public static void main(String[] args)
    {
        int floors = 6;
        int egg = 2;

        System.out.println(minEggDrop(floors, egg));
    }

}

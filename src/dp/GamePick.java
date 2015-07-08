package dp;

/*
 * 
 * N pots, each with some number of gold coins, are arranged in a line.
 *  You are playing a game against another player.
 *   You take turns picking a pot of gold. 
 *   You may pick a pot from either end of the line, remove the pot, and keep the gold pieces.
 *    The player with the most gold at the end wins. Develop a strategy for playing this game.
 *    
 *   i/p--  3, 9, 1, 2
 *   
 *     Max first player can win is 11 (2+9) , second Player (3+1) .
 */

class Player
{
    int first;
    int second;

}

public class GamePick
{

    /**
     * @param args
     */
    public static void pickForMaxProfit(int[] ip)
    {
        int rw = ip.length;
        Player[][] pl = new Player[rw + 1][rw + 1];

        for (int i = 0; i <= rw; i++)
        {
            for (int j = 0; j <= rw; j++)
            {
                pl[i][j] = new Player();
            }
        }

        int t = 1;
        while (t <= rw)
        {

            for (int i = 1; i <= rw - t + 1;)
            {

                for (int j = t; j <= rw; i++, j++)
                {

                    if (i == j)
                    {
                        pl[i][j].first = ip[i - 1];
                        pl[i][j].second = 0;
                    }
                    else
                    {

                        if ((ip[i - 1] + pl[i + 1][j].second) >= (ip[j - 1] + pl[i][j - 1].second))
                        {
                            pl[i][j].first = ip[i - 1] + pl[i + 1][j].second;
                            pl[i][j].second = pl[i + 1][j].first;
                        }
                        else
                        {
                            pl[i][j].first = ip[j - 1] + pl[i][j - 1].second;
                            pl[i][j].second = pl[i][j - 1].first;
                        }

                    }
                }
            }
            t++;
        }

        System.out.println(pl[1][rw].first + "   " + pl[1][rw].second);

    }

    public static void main(String[] args)
    {
        int[] arr =
        { 3, 9, 1, 2 };

        pickForMaxProfit(arr);
    }

}

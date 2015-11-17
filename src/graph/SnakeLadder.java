package graph;

import java.util.Scanner;

public class SnakeLadder
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[][] gameBoard = new int[101][101];

        for (int i = 1; i < 101; i++)
        {

            for (int j = 2; j < 101; j++)
            {
                if (j - i >= 6)
                {
                    gameBoard[i][j] = 1;
                }

            }
        }

        while (t-- > 0)
        {
            int ldr = in.nextInt();

            for (int i = 0; i < ldr; i++)
            {
                int start = in.nextInt();
                int end = in.nextInt();
                gameBoard[start][end] = 1;

            }

            int snk = in.nextInt();

            for (int i = 0; i < snk; i++)
            {
                int start = in.nextInt();
                int end = in.nextInt();
                gameBoard[start] = 0;
                gameBoard[start][end] = 1;

            }

        }

    }

}

package dp;

/*
 * Find maximum subsquare in a matrix made up of Xs and Os such that all four sides of subsquare are Xs. It does not matter what is inside
 * the subsquare. All 4 sides should be made up entirely of Xs
 * 
 * e.g 
 * 0 0 0 0 0 X         0,0  0,0  0,0  0,0  0,0  1,1
 * 0 X 0 X X X         0,0  1,1  0,0  1,1  1,2  2,3 
 * 0 X 0 X 0 X         0,0  2,1  0,0  2,1  0,0  3,1
 * 0 X X X X X         0,0  3,1  1,2  3,3  1,4  4,5
 * 0 0 0 0 0 0         0,0  0,0  0,0  0,0  0,0  0,0   
 * 
 * Output of above program should be 3
 */
public class SubsquarewithsidesAsX
{

    class var
    {
        int row;
        int col;
    }

    public int maxSubsquareSidesAsX(char[][] input)
    {
        int rw = input.length;
        int cl = input[0].length;

        var[][] vr = new var[rw][cl];

        for (int i = 0; i < rw; i++)
        {
            for (int j = 0; j < cl; j++)
            {
                vr[i][j] = new var();
            }
        }

        for (int i = 0; i < rw; i++)
        {

            for (int j = 0; j < cl; j++)
            {

                if (input[i][j] == 'X')
                {
                    if (i == 0 && j == 0)
                    {
                        vr[i][j].row = 1;
                        vr[i][j].col = 1;
                    }
                    else if (i == 0)
                    {
                        vr[i][j].row = 1;
                        vr[i][j].col = vr[i][j - 1].col + 1;
                    }
                    else if (j == 0)
                    {
                        vr[i][j].col = 1;
                        vr[i][j].row = vr[i - 1][j].row + 1;
                    }
                    else
                    {
                        vr[i][j].col = vr[i][j - 1].col + 1;
                        vr[i][j].row = vr[i - 1][j].row + 1;
                    }

                }
            }
        }

        for (int i = 0; i < rw; i++)
        {
            for (int j = 0; j < cl; j++)
            {
                System.out.print(vr[i][j].row + "," + vr[i][j].col + "  ");
            }
            System.out.println();
        }
        int max = 0;
        for (int i = rw - 1; i >= 0; i--)
        {
            for (int j = cl - 1; j >= 0; j--)
            {

                if (vr[i][j].row == 0 || vr[i][j].row == 1 || vr[i][j].col == 1)
                {
                    continue;
                }
                int min = Math.min(vr[i][j].row, vr[i][j].col);
                int k = 0;
                for (k = min; k > 1; k--)
                {
                    if (vr[i][j - k + 1].row >= k && vr[i - k + 1][j].col >= k)
                    {
                        break;
                    }
                }
                if (max < k)
                {
                    max = k;
                }
            }
        }
        return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        char[][] input =
        {
        { 'X', 'O', 'O', 'O', 'O', 'O' },
        { 'O', 'O', 'O', 'O', 'O', 'O' },
        { 'X', 'X', 'X', 'X', 'O', 'O' },
        { 'X', 'X', 'X', 'X', 'X', 'O' },
        { 'X', 'O', 'O', 'X', 'X', 'O' },
        { 'X', 'O', 'X', 'X', 'X', 'O' } };

        char[][] input1 =
        {
        { 'O', 'O', 'O', 'O', 'O', 'X' },
        { 'O', 'X', 'O', 'X', 'X', 'X' },
        { 'O', 'X', 'O', 'X', 'O', 'X' },
        { 'O', 'X', 'X', 'X', 'X', 'X' },
        { 'O', 'O', 'O', 'O', 'O', 'O' }, };

        SubsquarewithsidesAsX ss = new SubsquarewithsidesAsX();
        System.out.println(ss.maxSubsquareSidesAsX(input1));

    }

}

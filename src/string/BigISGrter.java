package string;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/bigger-is-greater
public class BigISGrter
{

    /**
     * @param args
     */

    public static String FindLexoGraphBig(String ip)
    {
        char[] chr = ip.toCharArray();
        char[] op = ip.toCharArray();
        int[] data = new int[chr.length];
        int pos = 0;
        for (int i = chr.length - 1; i > 0; i--)
        {

            if (chr[i] > chr[i - 1])
            {
                pos = i - 1;
                break;
            }
        }
        if (pos == 0 && (chr.length == 1 || chr[0] >= chr[1]))
        {
            return "no answer";
        }
        int j = 0;
        for (int i = chr.length - 1; i > pos; i--)
        {
            if (chr[i] > chr[pos])
            {
                j = i;
                break;
            }
        }
        // char x=chr[pos];
        op[pos] = chr[j];
        op[j] = chr[pos];

        for (int i = chr.length - 1; i > pos; i--)
        {
            char x = op[i];
            op[i] = op[pos + 1];
            op[pos + 1] = x;
            pos++;
        }

        return String.valueOf(op);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        int a = 1;
        while (t-- > 0)
        {
            String str = in.nextLine();

            System.out.println(FindLexoGraphBig(str));

        }

    }

}

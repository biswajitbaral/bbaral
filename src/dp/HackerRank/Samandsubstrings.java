package dp.HackerRank;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/sam-and-substrings
 * 
 * Samantha and Sam are playing a game. They have 'N' balls in front of them, each ball numbered from 0 to 9, except the first ball which is numbered from 1 to 9. Samantha calculates all the sub-strings of the number thus formed, one by one. If the sub-string is S, Sam has to throw 'S' candies into an initially empty box. At the end of the game, Sam has to find out the total number of candies in the box, T. As T can be large, Samantha asks Sam to tell T % (109+7) instead. If Sam answers correctly, he can keep all the candies. Sam can't take all this Maths and asks for your help.

 Help him!

 Input Format 
 A single line containing a string of numbers that appear on the first, second, third ball and so on.

 Output Format 
 A single line which is the number of candies in the box, T % (109+7)

 Constraints 
 1 ≤ N ≤ 2*105

 Sample Input #00

 16
 Sample Output #00

 23
 */
public class Samandsubstrings
{

    /**
     * @param args
     */
    static long max = 1000000007;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        /*
         * input = 3459
         * 
         * total numbers== 3 ,4 34,5 45 345,9 59 459 3459
         * 
         * sum of 4th block == 9+59+459+3459 =9+50+9+450+9+3450+9 4*9+10(5+45+345)== 4*input[4h element] +10* sum of 3rd
         * block
         */

        String str = in.nextLine();

        char[] as = str.toCharArray();
        int len = str.length();
        // long output=0;
        long tmp = Long.parseLong(String.valueOf(as[0]));
        long output = tmp;
        int k = 1;
        while (k < len)
        {
            tmp = (k + 1) * Integer.parseInt(String.valueOf(as[k])) + 10 * (tmp);
            tmp = tmp % max;
            output = (output + tmp) % max;

            k++;
        }
        System.out.println(output);
    }

}

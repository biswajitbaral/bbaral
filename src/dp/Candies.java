package dp;


/*
 * https://www.hackerrank.com/challenges/candies
 * Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line, and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies.

 Input 
 The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

 Ouput 
 Output a single line containing the minimum number of candies Alice must buy.

 Constraints 
 1 <= N <= 105 
 1 <= ratingi <= 105

 Sample Input

 3  
 1  
 2  
 2
 Sample Ouput

 4
 Explanation 
 Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.
 */

public class Candies
{

    /**
     * @param args
     */

    public static long totalCandies(long[] rank)
    {
        int len = rank.length;

        long[] data = new long[len];

        for (int i = 0; i < len; i++)
        {
            data[i] = 1;
        }
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++)
        {
            tmp[i] = 1;
        }

        for (int j = len - 2; j >= 0; j--)
        {
            if (rank[j] > rank[j + 1])
            {
                tmp[j] = tmp[j + 1] + 1;

            }

        }

        long sum = tmp[0];
        for (int i = 1; i < rank.length; i++)
        {
            if (rank[i] > rank[i - 1])
            {
                data[i] = data[i - 1] + 1;
                if (data[i] < tmp[i])
                {
                    data[i] = tmp[i];
                }
            }
            else
            {
                data[i] = tmp[i];
            }
            sum += data[i];
        }
        return sum;
    }

    public static void main(String[] args)
    {
        long[] a =
        { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 };
        long[] b =
        { 1, 2, 2 };
        /*
         * Scanner in = new Scanner(System.in); long n = in.nextLong(); long[] rank = new long[(int) n]; for (int i = 0;
         * i < n; i++) { rank[i] = in.nextLong(); }
         */
        System.out.println(totalCandies(a));

    }

}

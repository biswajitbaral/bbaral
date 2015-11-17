package array;

import java.util.HashMap;
import java.util.Map;

public class Twosum
{

    /**
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
     * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * 
     * For example:
     * 
     * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
     */
    public static int[] calIndex(int[] num, int target)
    {
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int k = 0;
        for (Integer i : num)
        {
            if (data.containsKey(target - i))
            {
                result[1] = k + 1;
                result[0] = data.get(target - i);
                break;
            }
            else
            {
                data.put(i, k + 1);
            }
            k++;
        }
        return result;

    }

    // if the input array is sorted
    public static int[] twoSum(int[] numbers, int target)
    {
        if (numbers == null || numbers.length == 0)
        {
            return null;
        }

        int i = 0;
        int j = numbers.length - 1;

        while (i < j)
        {
            int x = numbers[i] + numbers[j];
            if (x < target)
            {
                ++i;
            }
            else if (x > target)
            {
                j--;
            }
            else
            {
                return new int[]
                { i + 1, j + 1 };
            }
        }

        return null;
    }

    public static void main(String[] args)
    {
        int[] number =
        { 2, 7, 11, 15 };
        int target = 9;
        int[] result = calIndex(number, target);
        System.out.println("index1=" + result[0] + ", index2=" + result[1]);

        result = twoSum(number, target);
        System.out.println("index1=" + result[0] + ", index2=" + result[1]);
    }

}

package stack;

import java.util.Stack;

public class MaxHistogramArea
{

    /**
     * * Given an array representing height of bar in bar graph, find max histogram area in the bar graph. Max histogram
     * will be max rectangular area in the graph.
     * 
     */
    public static int maxArea(int[] arr)
    {

        Stack<Integer> stk = new Stack<Integer>();
        int top = 0;
        int maxarea = 0;
        int area = 0;
        int i;
        for (i = 0; i < arr.length;)
        {

            if (stk.isEmpty() || arr[stk.lastElement()] <= arr[i])
            {
                stk.push(i++);
            }
            else
            {

                int tmp = stk.pop();

                if (stk.isEmpty())
                {
                    area = arr[tmp] * i;
                }
                else
                {

                    area = arr[tmp] * (i - stk.lastElement() - 1);
                }
            }
            if (area > maxarea)
            {
                maxarea = area;
            }
        }

        while (!stk.isEmpty())
        {
            int tmp = stk.pop();

            if (stk.isEmpty())
            {
                area = arr[tmp] * i;
            }
            else
            {

                area = arr[tmp] * (i - stk.lastElement() - 1);
            }

            if (area > maxarea)
            {
                maxarea = area;
            }
        }
        return maxarea;
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 2, 1, 2, 3, 1 };

        int max = maxArea(arr);
        System.out.println(max);

    }

}

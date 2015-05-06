package array;

public class RotateArray
{

    /**
     * Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array
     * [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem? Best
     * way to solve this.
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        int[] arr =
        { 1, 2, 3, 4, 5, 6, 7 };

        rotate(arr, 3);
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }

    public static void rotate(int[] arr, int order)
    {

        if (arr == null || order < 0)
        {
            throw new IllegalArgumentException();
        }

        order = order % arr.length;

        if (arr.length == 1)
        {
            return;
        }
        int index = arr.length - order;

        reverse(arr, 0, index - 1);
        reverse(arr, index, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int start, int end)
    {
        while (start < end)
        {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }

    }

}

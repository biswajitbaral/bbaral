package search;

public class BinarySearch
{
    public static int binarySearch(int[] arr, int start, int end, int data)
    {
        if (end >= 1)
        {
            int mid = start + (end - start) / 2;

            if (arr[mid] == data)
            {
                return mid;
            }
            else if (arr[mid] > data)
            {
                return binarySearch(arr, start, mid - 1, data);
            }
            else
            {
                return binarySearch(arr, mid + 1, end, data);
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] =
            { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1)
        {
            System.out.println("Element is not present in array");
        }
        else
        {
            System.out.println("Element is present at index " + result);
        }

    }
}

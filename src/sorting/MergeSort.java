package sorting;

public class MergeSort
{

    /**
     * @param args
     */

    public void Merge(int[] arr, int start, int end)
    {
        System.out.println("St = " + start + " End = " + end);

        if (start < end)
        {
            int mid = (start + end) / 2;

            Merge(arr, start, mid);
            Merge(arr, mid + 1, end);

            Merge_sort(arr, start, mid, end);
            printArray(arr);
        }

    }

    public void Merge_sort(int[] arr, int p, int q, int r)
    {
        int l1 = q - p + 1;
        int r1 = r - q;

        int[] left = new int[l1 + 1];
        int[] right = new int[r1 + 1];
        int i, j;
        for (i = 0; i < left.length - 1; i++)
        {
            left[i] = arr[p + i - 1];
        }
        for (j = 0; j < right.length - 1; j++)
        {
            right[j] = arr[q + j];
        }
        i = 0;
        j = 0;
        left[l1] = Integer.MAX_VALUE;
        right[r1] = Integer.MAX_VALUE;
        for (int k = p; k <= r; k++)
        {

            if (left[i] <= right[j])
            {
                arr[k - 1] = left[i];
                i++;
            }
            else
            {
                arr[k - 1] = right[j];
                j++;
            }

        }

    }

    public void printArray(int[] ar)
    {

        for (int i = 0; i < ar.length; i++)
        {
            System.out.print(" " + ar[i]);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 3, 15, 18, 8, 12, 21, 6, 16 };

        MergeSort mg = new MergeSort();
        mg.Merge(arr, 1, arr.length);
        mg.printArray(arr);

    }

}

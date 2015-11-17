package sorting;

public class QuickSort
{

    /**
     * @param args
     */

    public void quicksort(int[] ar, int start, int end)
    {
        if (start < end)
        {
            int pId = partition(ar, start, end);

            quicksort(ar, start, pId - 1);

            quicksort(ar, pId + 1, end);
        }

    }

    public int partition(int[] arr, int start, int end)
    {

        int pivot = arr[end];

        int pIndex = start;
        for (int i = start; i < end; i++)
        {

            if (arr[i] <= pivot)
            {
                int tmp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = tmp;
                pIndex++;
            }

        }
        int tmp = arr[pIndex];
        arr[pIndex] = arr[end];
        arr[end] = tmp;
        printArray(arr);
        return pIndex;
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
        { 2, 8, 7, 1, 3, 5, 4 };

        QuickSort qs = new QuickSort();
        qs.quicksort(arr, 0, arr.length - 1);
        qs.printArray(arr);

    }

}

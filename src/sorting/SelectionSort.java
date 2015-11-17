package sorting;

/*
 * 
 * input -- 5 1 4 9 0 1 13 3
 * 
 * Steps by Selection Sort.--
 * 
 0 1 4 9 5 1 13 3
 0 1 4 9 5 1 13 3
 0 1 1 9 5 4 13 3
 0 1 1 3 5 4 13 9
 0 1 1 3 4 5 13 9
 0 1 1 3 4 5 13 9
 0 1 1 3 4 5 9 13
 * 
 * */

public class SelectionSort
{

    /**
     * @param args
     */
    public void selectionSort(int[] arr)
    {

        int len = arr.length;

        for (int i = 0; i < len - 1; i++)
        {

            int min = i;
            for (int j = i + 1; j < len; j++)
            {
                min = arr[j] < arr[min] ? j : min;
            }
            if (arr[i] > arr[min])
            {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            printArray(arr);
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
        { 5, 1, 4, 9, 0, 1, 13, 3 };

        SelectionSort ss = new SelectionSort();
        ss.printArray(arr);
        ss.selectionSort(arr);
    }

}

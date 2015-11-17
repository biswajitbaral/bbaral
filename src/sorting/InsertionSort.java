package sorting;

public class InsertionSort
{

    public void insertSort(int[] ar)
    {

        int len = ar.length;

        for (int i = 1; i < len; i++)
        {
            int tmp = ar[i];
            int j = i - 1;

            while (j >= 0 && ar[j] > tmp)
            {
                int x = ar[j + 1];
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = tmp;

            printArray(ar);

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

        InsertionSort is = new InsertionSort();

        is.insertSort(arr);

    }

}

package sorting;

public class CountSort
{

    /**
     * count sort can be used when u know the max range of the number.
     * 
     * 
     * 
     */
    public void countSort(int[] arr, int num)
    {

        int[] data = new int[num + 1];

        for (int i = 0; i < arr.length; i++)
        {
            data[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < data.length; i++)
        {
            while (data[i] > 0)
            {
                arr[j] = i;
                j++;
                data[i]--;
            }
        }
        printArray(arr);
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
        { 5, 2, 1, 3, 9, 10, 2, 1, 0, 6, 4, 8, 7, 6 };

        int maxNum = 10;

        CountSort cs = new CountSort();
        cs.countSort(arr, 10);

    }

}

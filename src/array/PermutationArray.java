package array;

public class PermutationArray
{

    /**
     * @param args
     */
    public void premArr(int[] arr, int start, int end)
    {

        if (start == end)
        {
            printArray(arr);
        }
        else
        {

            for (int i = start; i <= end; i++)
            {
                int tmp = arr[i];
                arr[i] = arr[start];
                arr[start] = tmp;

                premArr(arr, start + 1, end);
                tmp = arr[i];
                arr[i] = arr[start];
                arr[start] = tmp;

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
        { 1, 2, 3, 4 };
        PermutationArray pa = new PermutationArray();
        pa.premArr(arr, 0, arr.length - 1);

    }
}

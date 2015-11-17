package sorting;

/*
 *
 * input -- 5 1 4 9 0 1 13 3
 * 
 * output By Steps on Bubble Sort--
 * 
 1 4 5 0 1 9 3 13

 1 4 0 1 5 3 9 13

 1 0 1 4 3 5 9 13

 0 1 1 3 4 5 9 13

 0 1 1 3 4 5 9 13


 */
public class BubbleSort
{

    /**
     * @param args
     */
    public void bubbleSrt(int[] arr)
    {
        int len = arr.length;
        int swap = 1;

        for (int i = len - 1; i >= 0 && swap == 1; i--)
        {
            swap = 0;
            for (int j = 0; j <= i - 1; j++)
            {

                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = 1;
                }

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

        BubbleSort b = new BubbleSort();
        b.printArray(arr);
        b.bubbleSrt(arr);

    }

}

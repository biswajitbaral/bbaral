package sorting;

public class KthSmallestElement
{

    /**
     * from given array find the kth smallest element .
     */
    public int kthElement(int[] arr, int k)
    {
        int start = 0;
        int end = arr.length - 1;
        do
        {
            int pivot = partition(arr, start, end);
            if (pivot == k)
            {
                return arr[k];
            }
            else if (pivot < k)
            {
                start = pivot + 1;
            }
            else
            {
                end = pivot - 1;
            }

        } while (true);

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

        return pIndex;
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 65, 70, 75, 80, 85, 60, 55, 40, 45, 55, 98 };
        int findKthSmall = 6;
        KthSmallestElement ke = new KthSmallestElement();
        System.out.println(ke.kthElement(arr, findKthSmall));
    }

}

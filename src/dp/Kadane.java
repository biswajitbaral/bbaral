package dp;

public class Kadane
{

    /**
     * Java Program to Implement Kadane Algorithm
     */
    int maxSum;
    int start;
    int end;

    public Kadane(int maxSum, int start, int end)
    {
        this.maxSum = maxSum;
        this.start = start;
        this.end = end;
    }

    public Kadane()
    {
    };

    @Override
    public String toString()
    {
        return "Result [maxSum=" + maxSum + ", startPoint=" + start + ", endPoint=" + end + "]";
    }

    public Kadane findMaxsumSubseq(int[] arr)
    {

        int max = 0;
        int maxstartP = -1;
        int maxEndP = -1;
        int currentSt = 0;
        int tmpMax = 0;

        for (int i = 0; i < arr.length; i++)
        {
            tmpMax += arr[i];

            if (tmpMax < 0)
            {
                tmpMax = 0;
                currentSt = i + 1;

            }

            if (max < tmpMax)
            {
                maxstartP = currentSt;
                maxEndP = i;
                max = tmpMax;
            }

        }
        return new Kadane(max, maxstartP, maxEndP);

    }

    public static void main(String[] args)
    {
        int[] arr =
        { 2, 0, 2, -3 };
        Kadane k = new Kadane();
        System.out.println(k.findMaxsumSubseq(arr));
    }

}

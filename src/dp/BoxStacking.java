package dp;

import java.util.Arrays;

public class BoxStacking
{

    /**
     * 
     * Given different dimensions and unlimited supply of boxes for each dimension, stack boxes on top of each other
     * such that it has maximum height but with caveat that length and width of box on top should be strictly less than
     * length and width of box under it. You can rotate boxes as you like.
     * 
     * 1) Create all rotations of boxes such that length is always greater or equal to width 2) Sort boxes by base area
     * in non increasing order (length * width). This is because box with more area will never ever go on top of box
     * with less area. 3) Take T[] and result[] array of same size as total boxes after all rotations are done 4) Apply
     * longest increasing subsequence type of algorithm to get max height.
     * 
     * If n number of dimensions are given total boxes after rotation will be 3n. So space complexity is O(n) Time
     * complexity - O(nlogn) to sort boxes. O(n^2) to apply DP on it So really O(n^2)
     */

    public int maxHeight(Dimension input[])
    {

        // for ant box size , valid input can be if length > width.
        // so possible conditions for one box can be 3.
        Dimension[] rInput = new Dimension[input.length * 3];
        // set all the values into the rInput.
        createAllRotation(input, rInput);

        // sort all the boxes in descending order , so that smaller base can be on the top of larger base area

        Arrays.sort(rInput);

        int T[] = new int[rInput.length];
        int result[] = new int[rInput.length];

        for (int i = 0; i < rInput.length; i++)
        {
            T[i] = rInput[i].height;
            result[i] = i;
        }
        for (int i = 1; i < T.length; i++)
        {
            for (int j = 0; j < i; j++)
            {

                if (rInput[i].length < rInput[j].length && rInput[i].width < rInput[j].width)
                {
                    if (T[j] + rInput[i].height > T[i])
                    {
                        T[i] = T[j] + rInput[i].height;
                        result[i] = j;
                    }
                }
            }

        }
        // Result can also be found using result[] array.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T.length; i++)
        {
            if (T[i] > max)
            {
                max = T[i];
            }
        }

        return max;

    }

    private void createAllRotation(Dimension input[], Dimension[] rInput)
    {

        int index = 0;
        for (int i = 0; i < input.length; i++)
        {

            rInput[index++] = Dimension.createDimension(input[i].length, input[i].width, input[i].height);
            rInput[index++] = Dimension.createDimension(input[i].length, input[i].height, input[i].width);
            rInput[index++] = Dimension.createDimension(input[i].width, input[i].height, input[i].length);
        }
    }

    public static void main(String[] args)
    {
        BoxStacking bs = new BoxStacking();
        // 3, 2, 5 and 1 ,2 , 4

        Dimension input[] =
        { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };

        System.out.println(bs.maxHeight(input));
    }

}

class Dimension implements Comparable<Dimension>
{

    int height;
    int length;
    int width;

    Dimension(int height, int length, int width)
    {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    Dimension()
    {
    }

    static Dimension createDimension(int height, int side1, int side2)
    {
        Dimension d = new Dimension();
        d.height = height;
        if (side1 >= side2)
        {
            d.length = side1;
            d.width = side2;
        }
        else
        {
            d.length = side2;
            d.width = side1;
        }
        return d;
    }

    @Override
    public int compareTo(Dimension d)
    {
        if (this.length * this.width >= d.length * d.width)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public String toString()
    {
        return "Dimension [height=" + height + ", length=" + length + ", width=" + width + "]";
    }

}

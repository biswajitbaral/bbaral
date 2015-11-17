package dp;

import java.util.Arrays;
import java.util.Comparator;

class Job
{
    int start;
    int end;
    int profit;

    Job(int start, int end, int profit)
    {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

/**
 * Sort the jobs by finish time. For every job find the first job which does not overlap with this job and see if this
 * job profit plus profit till last non overlapping job is greater than profit till last job.
 * 
 * @param jobs
 * @return
 */

class EndTimeComparator implements Comparator<Job>
{

    @Override
    public int compare(Job arg0, Job arg1)
    {
        if (arg0.end <= arg1.end)
        {
            return -1;
        }
        return 1;
    }

}

public class JobScheduling
{

    public static int maxProfit(Job[] jobs)
    {

        int len = jobs.length;
        int[] data = new int[len];
        EndTimeComparator endC = new EndTimeComparator();
        Arrays.sort(jobs, endC);

        data[0] = jobs[0].profit;

        for (int i = 1; i < len; i++)
        {

            data[i] = Math.max(data[i - 1], jobs[i].profit);
            for (int j = 0; j < i; j++)
            {

                if (jobs[j].end <= jobs[i].start)
                {
                    data[i] = Math.max(data[i], data[j] + jobs[i].profit);

                }
            }

        }

        return data[len - 1];
    }

    public static void main(String[] args)
    {
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1, 3, 5);
        jobs[1] = new Job(2, 5, 6);
        jobs[2] = new Job(4, 6, 5);
        jobs[3] = new Job(6, 7, 6);
        jobs[4] = new Job(11, 15, 3);
        jobs[5] = new Job(7, 9, 4);

        System.out.println(maxProfit(jobs));

    }

}

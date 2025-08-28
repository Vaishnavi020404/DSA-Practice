/*

PLACEMENT ARRAY 2


LeetCode 56: Merge Intervals

Problem link: https://leetcode.com/problems/merge-intervals/

Core Logic:

Sort the intervals by their start time. This is the crucial first step.
Iterate through the sorted intervals, comparing each to the last merged interval.
If the current interval overlaps with the last merged one, merge them by updating the end time.
If there's no overlap, the last merged interval is complete; add the current one as a new entry.

Time Complexity: O(n log n)
The primary time complexity comes from sorting the array, which is O(n log n).
The single pass to merge intervals takes O(n).
The total time complexity is dominated by the sorting step, so it is O(n log n).

Space Complexity: O(n)
In the worst-case scenario (no overlaps), the finalJobs list will grow to hold all 'n' intervals.
This requires additional space proportional to the number of intervals, so it is O(n).

Things to remember:

The Lambda Function Explained
A lambda function is a way to create a very short, anonymous function. Think of it as a one-line rule you can give to another method.

In our code, Arrays.sort() is the method that needs a rule for sorting. The lambda expression (job1, job2) -> job1[0] - job2[0] is that rule.

job1, job2: These are the two things being compared.

->: This means "do this" or "go to". It separates the inputs from the action.

job1[0] - job2[0]: This is the action. It tells the sorting method to subtract the start time of the second job from the start time of the first. The result of this simple subtraction determines the order:

Negative result: job1 comes first.

Positive result: job2 comes first.

Zero result: The order doesn't matter.

This one-line rule replaces a much longer, more complicated block of code called an "anonymous inner class" that was used in older versions of Java. It's a modern shortcut to make the code cleaner and more readable.

You can use Integer.compare(job1[0], job2[0]) to avoid potential integer overflow.
*/
import java.util.*;
public class Merged_Intervals_2{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the total number of jobs: ");
        int numJobs=sc.nextInt();

        int[][] jobs=new int[numJobs][2];

        System.out.println("Enter the start and end time for each job(e.g.,1 5): ");
        for(int i=0;i<numJobs;i++){
            System.out.println("Job"+(i+1)+": ");
            jobs[i][0]=sc.nextInt();
            jobs[i][1]=sc.nextInt();
        }


        int[][] mergedJobs=merge(jobs);

        System.out.println("\nMerged Jobs: ");
        for(int[] job: mergedJobs){
            System.out.println(Arrays.toString(job));
        }
    }

    public static int[][] merge(int[][] allJobs){
        Arrays.sort(allJobs,(job1,job2)->job1[0]-job2[0]);

        List<int[]> finalJobs=new ArrayList<>();

        int[] currentJob=allJobs[0];

        finalJobs.add(currentJob);

        for(int[] nextJob:allJobs){
            int currentEnd=currentJob[1];

            int nextStart=nextJob[0];
            int nextEnd=nextJob[1];

            if(currentEnd >= nextStart){
                currentJob[1]=Math.max(currentEnd,nextEnd);
            }else{
                currentJob=nextJob;
                finalJobs.add(currentJob);
            }
        }
        return finalJobs.toArray(new int[finalJobs.size()][]);
    }
}
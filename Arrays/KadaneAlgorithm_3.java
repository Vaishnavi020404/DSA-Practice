/*
 * PLACEMENT ARRAY 3
 * 28/7/25
 * LeetCode 53: Maximum Subarray
 * Problem link: https://leetcode.com/problems/maximum-subarray/
 *
 * Core Logic:
 * Kadane's Algorithm finds the maximum sum contiguous subarray in O(n) time.
 * 1. Initialize maxSum with the first element and currentSum as 0.
 * 2. Iterate through each element of the array:
 *    - Add the current element to currentSum.
 *    - Update maxSum if currentSum is greater than maxSum.
 *    - If currentSum becomes negative, reset it to 0. Negative sums will reduce
 *      the total for the next subarray, so we discard them.
 * 3. After finishing the iteration, maxSum holds the largest subarray sum.
 *
 * Why Kadane's Algorithm is better than Brute Force:
 * - Brute Force checks all possible subarrays, resulting in O(n^2) or O(n^3)
 *   time complexity depending on implementation.
 * - Kadane's Algorithm uses a running sum and resets on negative sums, giving O(n)
 *   time complexity with only constant extra space.
 * - Therefore, Kadane's is much faster and scalable for large arrays.
 *
 * Time Complexity: O(n)
 * - Single pass through the array.
 *
 * Space Complexity: O(1)
 * - No extra arrays are used; only two integer variables.
 *
 * Things to remember:
 * - Kadane's Algorithm only works because a negative running sum can never
 *   contribute to a maximum sum subarray, so we reset it.
 * - Initialize maxSum with the first element to handle arrays with all negative numbers.
 */
import java.util.*;
public class KadaneAlgorithm_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxSum = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);

    }
    // Function to find maximum subarray sum using Kadane's Algorithm
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }


}


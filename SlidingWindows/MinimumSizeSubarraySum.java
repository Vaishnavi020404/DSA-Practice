// LeetCode 209 - Minimum Size Subarray Sum
// Date: 26/01/2026
// Link: https://leetcode.com/problems/minimum-size-subarray-sum/
// Tags: Array / Sliding Window / Two Pointers
// Approach - Sliding Window:
//
//   Problem:
//   Given an array of positive integers and a target value,
//   find the minimum length of a contiguous subarray
//   whose sum is greater than or equal to the target.
//
//   Algorithm:
//   1) Initialize two pointers:
//        - i = 0 (start of window)
//        - j = 0 (end of window)
//   2) Initialize:
//        - sum = 0 (current window sum)
//        - minLength = infinity (Integer.MAX_VALUE)
//   3) Move j from left to right:
//        a) Add nums[j] to sum (expand window)
//        b) While sum >= target:
//             - Update minLength with (j - i + 1)
//             - Subtract nums[i] from sum
//             - Increment i (shrink window from left)
//   4) Continue until j reaches the end of the array
//   5) If minLength was never updated, return 0
//      Otherwise, return minLength
//
//   Key Idea:
//   - Expand window until condition is satisfied
//   - Shrink window to minimize length
//   - Each element is added and removed once
//
// Time Complexity: O(n)
//   - Both pointers move forward at most n times
//
// Space Complexity: O(1)
//   - No extra data structures used

import java.util.Scanner;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            sum += nums[j];

            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum size of subarray: " + result);

        sc.close();
    }
}

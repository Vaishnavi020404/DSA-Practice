//===========================================================
// LeetCode 167 - Two Sum II - Input Array Is Sorted
// Date: 26/12/2025
// Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Tags: Array / Two Pointers / 1-based Index
// Approach:
//   1) Two-pointer approach (O(n) time, O(1) space)
//===========================================================

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //---------------- Input Section ----------------
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter the array elements (sorted): ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum: ");
        int target = sc.nextInt();

        //---------------- Two-pointer Approach ----------------
        int[] answer = twoSum(numbers, target);
        System.out.println("Indices of numbers that sum to target: " + Arrays.toString(answer));

        sc.close();
    }

    //===========================================================
    // Two-pointer Approach
    // Time: O(n), Space: O(1)
    //===========================================================
    static int[] twoSum(int[] numbers, int target) {
        int i = 0;                  // start pointer
        int j = numbers.length - 1; // end pointer

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                // return 1-based indices
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++; // need a bigger sum
            } else {
                j--; // need a smaller sum
            }
        }

        // fallback (problem guarantees one solution)
        return new int[]{-1, -1};
    }
}

// Leetcode 162: Find Peak Element
// Problem link: https://leetcode.com/problems/find-peak-element/

// Core Logic:
// Binary Search to find the peak element. A peak is an element that is strictly greater than its neighbors.
// The key idea is: if mid > mid+1, then the peak lies on the left including mid
// else, the peak lies on the right side.

// I first solved this using a linear search — just check the max element by comparing all — O(n)
// But binary search gives a better optimized solution — O(log n)

// Time Complexity: O(log n)
// Space Complexity: O(1)

// Things to remember:
// 1. You can return any peak, not necessarily the first or largest one
// 2. Always compare nums[mid] with nums[mid+1] for binary search movement
// 3. Works even when array has just one element

import java.util.*;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element found at index: " + peakIndex);
    }

    static int findPeakElement(int[] nums) {
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > nums[max]) {
        //         max = i;
        //     }
        // }
        // return max;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

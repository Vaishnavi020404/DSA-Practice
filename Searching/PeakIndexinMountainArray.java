// 🔹 Leetcode: 852. Peak Index in a Mountain Array
// 🔹 Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
// 🔹 Solved using both Linear Search and Binary Search
//
// 🔹 Core Idea:
// First approach: Use Linear Search to find the maximum element's index.
// Optimized approach: Use Binary Search since the array is a mountain array (strictly increasing then decreasing).
// 
// 🔹 Time Complexity:
// Linear Search – O(n)
// Binary Search – O(log n) ✅
// 
// 🔹 Space Complexity: O(1)
//
// 🔹 Things to Remember:
// - Check the mid element and its next element
// - If nums[mid] > nums[mid + 1], then the peak is towards left (including mid)
// - Else, the peak is towards right (excluding mid)
// - Loop stops when start == end, which is the peak index

import java.util.Scanner;

public class PeakIndexinMountainArray {

       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the mountain array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int peakIndex = peakIndexInMountainArray(nums);
        System.out.println("Peak index is: " + peakIndex);
    }

    public static int peakIndexInMountainArray(int[] nums) {
        // // Linear search approach (Brute Force)
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > nums[max]) {
        //         max = i;
        //     }
        // }
        // return max;

        // Binary Search approach (Optimized)
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

        return start; // or return end; both are same here
    }

 
}

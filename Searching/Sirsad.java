// Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Problem: LeetCode 81 - Search in Rotated Sorted Array II (With Duplicates)


//SIRSAD stand for SearchingInRotatedSortingArrayWithDuplicates which also means Search in Rotated Sorted Array II as per leetcode


//
// ✅ Extension of Leetcode 33:
// This problem is a direct extension of Leetcode 33 (Search in Rotated Sorted Array), 
// but here we also need to handle duplicate values — which adds edge cases to the binary search logic.
//
// 🧠 Problem Description:
// You are given an array that is sorted in ascending order but possibly rotated at some pivot.
// The array may contain duplicate values.
// Your task is to find the index of a given target in O(log n) time (if possible).
//
// 🔁 What I tried earlier (based on Leetcode 33):
// - First wrote brute-force linear search (O(n)), which worked for small inputs.
// - Tried finding the pivot using a simple 4-case logic from Leetcode 33 (assuming distinct values).
// - The pivot logic failed when duplicates were present — especially when start, mid, and end 
//   were all equal (e.g. [2, 2, 2, 3, 2]) — this breaks the "binary" nature of binary search.
//
// ✅ Final Correct Approach (Handles Duplicates):
// 1. Modified pivot-finding logic to handle duplicates.
//    - If nums[start] == nums[mid] == nums[end], increment start and decrement end to shrink the range.
// 2. Once pivot is found, perform binary search in either left or right half based on target.
// 3. If pivot is not found (array isn't rotated), perform binary search on the entire array.
//
// ⏱️ Time Complexity: O(log n) on average; in worst-case (with many duplicates), it can degrade to O(n)
// 🗃️ Space Complexity: O(1)


import java.util.Scanner;

public class Sirsad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements (may contain duplicates):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter target element to search:");
        int target = sc.nextInt();

        int index = search(nums, target);
        System.out.println("Index of target: " + index);
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        // If array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // If pivot is found, check both subarrays
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    public static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) return mid;
            if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) return start;
                start++;

                if (end > start && nums[end - 1] > nums[end]) return end - 1;
                end--;
            } else if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}

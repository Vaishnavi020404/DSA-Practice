// LeetCode 80 - Remove Duplicates from Sorted Array II
// Date: 24/12/2025
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Tags: Array / Two Pointers / In-Place
//
// Problem Summary:
//   Given a sorted array, remove duplicates in-place such that
//   each element appears at most twice.
//   Return the length k.
//
// Approaches Included:
//   1) Optimized Two-Pointer Approach (Industry Standard)
//
// Note:
//   Only the first k elements matter after execution.

import java.util.*;

public class RemoveDuplicatesSortedArrayII {

    
    // =====================================================
    // OPTIMIZED APPROACH (CLEAN TWO POINTERS)
    // =====================================================
    // Idea:
    //   - Keep k as write pointer
    //   - Compare current element with nums[k - 2]
    //   - If different, it's safe to write
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // This is the canonical LeetCode 80 solution
    public static int removeDuplicatesOptimized(int[] nums) {

        if (nums.length <= 2) return nums.length;

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // =====================================================
    // MAIN METHOD (USER INPUT & DEMO)
    // =====================================================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums1 = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        // Clone for fair comparison
        int[] nums2 = nums1.clone();



        // Optimized
        int kOptimized = removeDuplicatesOptimized(nums2);
        System.out.println("\n\nOptimized Result:");
        System.out.print("k = " + kOptimized + ", array = ");
        for (int i = 0; i < kOptimized; i++) {
            System.out.print(nums2[i] + " ");
        }

        sc.close();
    }
}

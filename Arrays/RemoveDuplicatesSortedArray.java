// LeetCode 26 - Remove Duplicates from Sorted Array
// Date: 24/12/2025
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Tags: Array / Two Pointers / In-Place
//
// Problem Summary:
//   Given a sorted array, remove duplicates in-place such that each unique
//   element appears only once. Return the number of unique elements (k).
//
// Approaches Included:
//   1) Brute Force (User's Original Logic - Counting & Overwriting)
//   2) Optimized Two-Pointer Approach (Clean & Minimal)
//
// Note:
//   Only the first k elements matter after execution.

import java.util.*;

public class RemoveDuplicatesSortedArray {

    // =====================================================
    // BRUTE FORCE APPROACH (YOUR LOGIC)
    // =====================================================
    // Idea (as used by you):
    //   - Compare adjacent elements
    //   - Count unique elements manually
    //   - Overwrite array when a new element is found
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Logic is more complicated than necessary
    public static int removeDuplicatesBrute(int[] nums) {

        int k=1;
        for(int i=1;i<nums.length;i++){
            int start=nums[0];
            int end=nums[1];
            if(nums[i-1]==nums[i]){
                end++;
            }else{
                k++;
                nums[k-1]=nums[i];
                start++;
                end++;
            }
        }
        return k;
    }
    
    // =====================================================
    // OPTIMIZED APPROACH (Clean Two Pointers)
    // =====================================================
    // Idea:
    //   - One pointer reads (i)
    //   - One pointer writes (k)
    //   - Compare current with last written unique
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Preferred interview solution
    public static int removeDuplicatesOptimized(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // =====================================================
    // MAIN METHOD (User Input & Demo)
    // =====================================================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums1 = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        // Clone array so both approaches get same input
        int[] nums2 = nums1.clone();

        // Brute Force (Your logic)
        int kBrute = removeDuplicatesBrute(nums1);
        System.out.println("\nBrute Force (Your Approach):");
        System.out.print("k = " + kBrute + ", array = ");
        for (int i = 0; i < kBrute; i++) {
            System.out.print(nums1[i] + " ");
        }

        // Optimized
        int kOptimized = removeDuplicatesOptimized(nums2);
        System.out.println("\n\nOptimized Two-Pointer Approach:");
        System.out.print("k = " + kOptimized + ", array = ");
        for (int i = 0; i < kOptimized; i++) {
            System.out.print(nums2[i] + " ");
        }

        sc.close();
    }
}

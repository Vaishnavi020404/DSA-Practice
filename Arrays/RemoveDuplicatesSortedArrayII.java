// LeetCode 80 - Remove Duplicates from Sorted Array II
// Date: 24/12/2025
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Tags: Array / Two Pointers / In-Place
//
// Problem Summary:
//   Given a sorted array, remove duplicates in-place such that
//   each element appears at most twice.
//   Return the length k.
//K-2->If this number is the same as the one that appeared two positions ago, then adding it would make three copies → reject.”
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

// Think of it like this:

// i = your hand picking vegetables/stones
// You just look at each one in the pile; you don’t rearrange the pile yet.

// k = the first empty spot in your organized row
// You only place something here if it’s allowed (i.e., won’t make too many duplicates).

// nums[k-2] = the guard
// If the vegetable/stone you picked is the same as the one two spots back, putting it at k would make a third copy → skip it.

// You never touch what you pick (i); it’s just the candidate. You only write to k when safe, building a perfectly organized start of the line.

// So yes, you’re not checking the whole line or fixing past mistakes. You’re just selecting and safely placing the allowed ones at the front. Everything beyond k-1 doesn’t matter until it’s your turn to fill it.

// That’s why the “not equal to k-2” is enough to enforce the “at most twice” rule without touching existing duplicates.
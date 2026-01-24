//===========================================================
// LeetCode 27 - Remove Element
// Date: 24/01/2026
// Link: https://leetcode.com/problems/remove-element/
// Tags: Array / Two Pointers
//
// Pattern Used:
// Slow–Fast Pointer / Write-Index Compaction Pattern
//
// Approach:
// ----------------------------------------------------------
// We use two pointers:
// 1) i -> reads every element from start to end
// 2) k -> writes valid elements to the front of the array
//
// Whenever nums[i] is NOT equal to val:
//   - copy nums[i] to nums[k]
//   - increment k
//
// After traversal:
// - First k elements contain all valid elements
// - Elements after k are ignored
//
// Time Complexity: O(n)
// Space Complexity: O(1)
//===========================================================

import java.util.Scanner;

public class RemoveElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value to remove: ");
        int val = sc.nextInt();

        //--------------- Processing Section ----------------
        int k = removeElementFromArray(arr, val);

        //--------------- Output Section ----------------
        System.out.println("\nNumber of elements after removal: " + k);
        System.out.print("Updated array (first " + k + " elements): ");

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }

    //===========================================================
    // Method: removeElementFromArray
    // Uses Slow–Fast Pointer / Write-Index Compaction Pattern
    // Returns count of elements NOT equal to val
    //===========================================================
    static int removeElementFromArray(int[] nums, int val) {

        int k = 0; // write pointer

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

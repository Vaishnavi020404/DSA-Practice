//===========================================================
// LeetCode 75 - Sort Colors
// Date: 08/10/2025
// Link: https://leetcode.com/problems/sort-colors/
// Tags: Array / Two Pointers / Dutch National Flag
// Approach:
//   1) Dutch National Flag Algorithm (Optimal, in-place, one-pass)
//   2) Counting Sort (Alternative, uses extra space)
// Time Complexity: O(n) for Dutch Flag, O(n) for Counting Sort
// Space Complexity: O(1) for Dutch Flag, O(k) for Counting Sort (k = number of colors)
//===========================================================

import java.util.Scanner;

public class SortColors {

    //===========================================================
    // Approach 1: Dutch National Flag Algorithm
    // Sorts array in-place using three pointers: low, mid, high
    // 0 → front, 1 → middle, 2 → back
    //===========================================================
    public static void sortColors(int[] nums) {
        int low = 0;           // next position for 0
        int mid = 0;           // current element to check
        int high = nums.length - 1; // next position for 2

        while(mid <= high) {
            if(nums[mid] == 0) {
                // Swap 0 to the front
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                // 1 is in correct position, just move mid
                mid++;
            } else { // nums[mid] == 2
                // Swap 2 to the back
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--; // do NOT move mid here
            }
        }
    }

    //===========================================================
    // Main Function: Take input and print sorted array
    //===========================================================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array size input
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Take array elements input
        System.out.println("Enter the array elements (0, 1, or 2 only):");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Sort the array using Dutch Flag
        sortColors(nums);

        // Print the sorted array
        System.out.println("Sorted array:");
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

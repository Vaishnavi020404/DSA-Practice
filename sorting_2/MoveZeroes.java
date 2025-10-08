//===========================================================
// LeetCode 283 - Move Zeroes
// Date: 08/10/2025
// Link: https://leetcode.com/problems/move-zeroes/
// Tags: Array, Two Pointers
// Approach:
//   1) Use a single pointer to track the next position for a non-zero number.
//   2) Traverse the array, whenever a non-zero number is found, swap it with the position pointer.
//   3) After the loop, all zeros are automatically pushed to the end.
// Time Complexity: O(n)
// Space Complexity: O(1)
//===========================================================

import java.util.Scanner;

public class MoveZeroes {

    // Function to move all zeros to the end while maintaining relative order
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0; // Position to place the next non-zero number

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap current non-zero with the position pointer
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;

                // Move pointer to next position
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function to move zeroes
        moveZeroes(nums);

        // Output the modified array
        System.out.println("Array after moving zeroes:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}

// Notes on why it never swaps with another non-zero:
// 1) nonZeroIndex only moves forward when a non-zero is placed.
// 2) This means it always points to the first zero in the part we have processed.
// 3) Any non-zero number always swaps with that zero, never with another non-zero.
// 4) Think of it like: nonZeroIndex marks the next empty slot for a non-zero number.

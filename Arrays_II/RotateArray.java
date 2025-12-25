//===========================================================
// LeetCode XXX - Rotate Array
// Date: 25/12/2025
// Link: https://leetcode.com/problems/rotate-array/
// Tags: Array / In-place / Two Pointers
// Approach: 
//   1) Brute-force using extra array (O(n) time, O(n) space)
//   2) Optimal in-place using reverse method (O(n) time, O(1) space)
// Time Complexity: O(n) for both approaches
// Space Complexity: 
//   Brute-force: O(n)
//   Optimal: O(1)
//===========================================================

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //---------------- Input Section ----------------
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k (number of rotations): ");
        int k = sc.nextInt();

        //---------------- Brute-force Approach ----------------
        int[] numsBrute = Arrays.copyOf(nums, nums.length);
        rotateBruteForce(numsBrute, k);
        System.out.println("\nRotated array (Brute-force, O(n) extra space): " + Arrays.toString(numsBrute));

        //---------------- Optimal Approach ----------------
        int[] numsOptimal = Arrays.copyOf(nums, nums.length);
        rotateOptimal(numsOptimal, k);
        System.out.println("Rotated array (Optimal, O(1) space): " + Arrays.toString(numsOptimal));

        sc.close();
    }

    //===========================================================
    // Brute-force: uses extra array
    // Time: O(n), Space: O(n)
    //===========================================================
    static void rotateBruteForce(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k > n
        int[] answer = new int[n];

        int first = 0;
        int last = n - k;

        for (int i = 0; i < n; i++) {
            if (last < n) {
                answer[i] = nums[last++];
            } else {
                answer[i] = nums[first++];
            }
        }

        // copy back
        for (int i = 0; i < n; i++) {
            nums[i] = answer[i];
        }
    }

    //===========================================================
    // Optimal Approach: In-place using reverse
    // Time: O(n), Space: O(1)
    //===========================================================
    static void rotateOptimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k > n

        // Reverse the whole array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse a subarray
    static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}

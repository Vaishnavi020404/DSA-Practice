//===========================================================
// LeetCode 1464 - Maximum Product of Two Elements in an Array
// Date: 23/09/2025
// Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// Tags: Array / Math
// Approach: 
//   1) Optimized Approach: find the two largest elements in one pass O(n)
//   2) Brute-Force Approach: nested loop comparing all pairs O(n^2)
// Time Complexity: O(n) optimized, O(n^2) brute-force
// Space Complexity: O(1)
//===========================================================

import java.util.Scanner;

public class MaximumProductTwoElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //--------------- Processing Section ----------------
        int maxProductOptimized = maxProduct(nums);
        int maxProductBruteForce = maxProductBruteForce(nums);

        //--------------- Output Section ----------------
        System.out.println("\nResults:");
        System.out.println("Optimized Approach: " + maxProductOptimized);
        System.out.println("Brute-Force Approach: " + maxProductBruteForce);

        sc.close();
    }

    // Optimized: find two largest elements
    static int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    // Brute-force: nested loop comparing all pairs
    static int maxProductBruteForce(int[] nums) {
        int maxProd = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = (nums[i] - 1) * (nums[j] - 1);
                if (prod > maxProd) {
                    maxProd = prod;
                }
            }
        }
        return maxProd;
    }
}

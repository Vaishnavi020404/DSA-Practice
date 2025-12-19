//===========================================================
// LeetCode 11 - Container With Most Water (User Input Version)
// Date: 19/12/2025
// Link: https://leetcode.com/problems/container-with-most-water/
// Tags: Two Pointers / Array / User Input
// Approach Summary & Notes for Revision:
//   1) Use two pointers: left at start, right at end.
//   2) Calculate area = (right-left) * min(height[left], height[right]).
//   3) Move the pointer with smaller height inward.
//   4) Track the maximum area found in a variable.
// Time Complexity: O(n) - each element visited at most once
// Space Complexity: O(1) - no extra space except variables
//===========================================================

import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of heights: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        // Input array elements
        System.out.println("Enter the heights:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        // Compute max area
        int maxWater = maxArea(height);
        System.out.println("Maximum water the container can store: " + maxWater);
        sc.close();
    }

    // Two-pointer approach to find max container area
    public static int maxArea(int[] height) {
        int max = 0;                  // stores maximum area
        int left = 0;                 // left pointer
        int right = height.length - 1; // right pointer

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                max = area;           // update max if current area is bigger
            }

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}

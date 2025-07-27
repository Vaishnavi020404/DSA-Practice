/* 
   PROBLEM: 162. Find Peak Element
  LINK: https://leetcode.com/problems/find-peak-element/
  DIFFICULTY: Medium

Approach Used: Binary Search with comparison to mid+1
Core Idea: If nums[mid] > nums[mid+1] → peak lies on left (including mid); else → peak lies right
Linear Search (Brute Force): Traverse and return index where nums[i] > nums[i-1] && nums[i] > nums[i+1]
ime ComplexityBrute Force: O(n)
     Binary Search: O(log n)
Space Complexity: O(1)
What to Remember:
     nums[i] ≠ nums[i+1] → guaranteed peak exists
     We don't care which peak we return — any one is okay
*/

import java.util.Scanner;

public class FindPeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int peakIndex = obj.findPeakElement(nums);
        System.out.println("Peak element found at index: " + peakIndex);
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}


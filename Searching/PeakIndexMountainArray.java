/* 
  💻 PROBLEM: 852. Peak Index in a Mountain Array
  🔗 LINK: https://leetcode.com/problems/peak-index-in-a-mountain-array/
  🟦 DIFFICULTY: Easy
  
Approach Used: Binary Search on the slope (Strictly increasing then decreasing array)
Core Idea: If mid > mid+1 → peak lies on left (including mid); else → peak lies on right
Linear Search (Brute Force): Traverse whole array and find index of max element

Time Complexity:
    Brute Force: O(n)
    Binary Search: O(log n)
Space Complexity: O(1)
What to Remember:
     Mountain array = strictly increasing then strictly decreasing
     Check mid with mid+1, move left or right accordingly
*/

import java.util.Scanner;

public class PeakIndexMountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the mountain array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the mountain array elements (strictly increasing then decreasing):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int peakIndex = obj.peakIndexInMountainArray(arr);
        System.out.println("Peak index is: " + peakIndex);
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid; // peak is to the left or at mid
            } else {
                start = mid + 1; // peak is to the right
            }
        }

        return start; // or end (both are same here)
    }
}


//===========================================================
// LeetCode 912 - Sort an Array
// Date: 08/10/2025
// Link: https://leetcode.com/problems/sort-an-array/
// Tags: Array / Divide and Conquer / Merge Sort
// Approach:
//   1) Merge Sort (Divide and Conquer, O(n log n))
//   2) Splits the array recursively until subarrays have 1 element
//   3) Merges sorted subarrays into larger sorted arrays
// Time Complexity: O(n log n)
// Space Complexity: O(n) (extra arrays for merging)
//===========================================================

import java.util.Arrays;
import java.util.Scanner;

public class SortArray912 {

    //===========================================================
    // Merge Sort Function
    //===========================================================
    public static int[] mergeSort(int[] arr) {
        if(arr.length <= 1) return arr; // base case: array of size 0 or 1

        int mid = arr.length / 2;

        // Split array into left and right halves
        int[] left = Arrays.copyOfRange(arr, 0, mid);      // 0 to mid-1
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // mid to end

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge sorted halves
        return merge(left, right);
    }

    //===========================================================
    // Merge Function
    // Combines two sorted arrays into one sorted array
    //===========================================================
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Merge elements in sorted order
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) result[k++] = left[i++];
            else result[k++] = right[j++];
        }

        // Copy remaining elements from left
        while(i < left.length) result[k++] = left[i++];
        // Copy remaining elements from right
        while(j < right.length) result[k++] = right[j++];

        return result;
    }

    //===========================================================
    // Main function: Takes input and prints sorted array
    //===========================================================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter the number of unsorted array elements: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort the array
        arr = mergeSort(arr);

        // Print the sorted array
        System.out.println("Sorted array:");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}

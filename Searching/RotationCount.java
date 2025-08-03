
// Problem Link (Non-Duplicates): https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Problem Link (With Duplicates): https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
//
// Problem:
// You are given a sorted and rotated array. You need to find the number of times it has been rotated.
// This is equal to the index of the minimum element in the array.
//

//
// Final Approach:
// 1. Use a modified binary search to find the pivot (i.e., the largest element).
// 2. If pivot is found at index `i`, the minimum is at `i + 1`.
// 3. If pivot not found (array not rotated), return 0.
//
// ➕ This logic works for both:
//   ✅ Arrays with all distinct elements
//   ✅ Arrays with duplicates (requires extra check for equal elements)
//
// Time Complexity: O(log n) for distinct, O(n) in worst case for duplicates
// Space Complexity: O(1)
//

import java.util.Scanner;

public class RotationCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter elements of the array (may contain duplicates):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find pivot and calculate number of rotations
        int pivot = findPivotWithDuplicates(nums);
        int rotationCount = (pivot == -1) ? 0 : pivot + 1;

        System.out.println("Number of rotations in the array: " + rotationCount);
    }

    // ✅ Works for both duplicates and non-duplicates
    static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid > mid+1 → mid is pivot
            if (mid < end && nums[mid] > nums[mid + 1]) return mid;

            // Case 2: mid < mid-1 → mid-1 is pivot
            if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            // Case 3: Duplicates — can't decide, shrink both ends
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                // Check if start is pivot
                if (start < end && nums[start] > nums[start + 1]) return start;
                start++;

                // Check if end is pivot
                if (end > start && nums[end - 1] > nums[end]) return end - 1;
                end--;
            }

            // Case 4: Left side is unsorted → pivot is in left
            else if (nums[start] > nums[mid]) {
                end = mid - 1;
            }

            // Case 5: Right side is unsorted → pivot is in right
            else {
                start = mid + 1;
            }
        }

        return -1; // If array is not rotated
    }
}

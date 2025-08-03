// Title: Rotation Count in a Rotated Sorted Array (With Duplicates)
// Description:
// Given a sorted and rotated array (possibly containing duplicates),
// this program determines the number of times the array has been rotated.
// The rotation count is equal to the index of the minimum element,
// which is one more than the index of the pivot (maximum element).
//
// Approach:
// ✅ Use a modified binary search to find the pivot (largest element).
// ✅ Handle all edge cases including duplicates using proper checks.
// ✅ If no pivot is found (array is not rotated), return 0.
//
// Time Complexity: 
// - O(log n) for distinct elements
// - O(n) in worst case for duplicates due to linear skips
//
// Space Complexity: O(1)

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

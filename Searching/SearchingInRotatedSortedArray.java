// SIRSA - Searching In Rotated Sorted Array
//
// Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Problem: LeetCode 33 - Search in Rotated Sorted Array
//
// 📌 Description:
// You're given a sorted array (in ascending order) that may have been rotated.
// You need to find the index of a given target in O(log n) time.
//
//  What I Tried Earlier:
// - First used a brute-force linear search → worked on small inputs, but gave TLE for large ones.
// - Then tried splitting manually into two halves and checking both sides — failed on edge cases.
// - Finally realized: to get O(log n), binary search is the only way — even with rotation.
//
// ✅ Final Approach:
// 1. First, find the pivot — the index of the largest element — using binary search.
// 2. Pivot splits the array into two sorted halves.
// 3. Based on where the target lies (compared to nums[0]), apply binary search on the correct half.
// 4. Also handle case when array is not rotated at all (pivot = -1).
//
// 📌 Notes:
// - I first learned this concept as "SIRSA" from a tutor before realizing it maps to Leetcode 33.
// - That's why this version uses `int` return type for the `findPivot` method.
// - Later, I learned Leetcode 81 (with duplicates) uses a `boolean` return approach — both approaches are included.
//
// ⏱ Time Complexity: O(log n)
//  Space Complexity: O(1)



import java.util.Scanner;

public class SearchingInRotatedSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input size of the array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Take input elements of the array
        System.out.println("Enter elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Take the target element to search
        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        // Call the search function and print the result
        int index = search(nums, target);
        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found.");
        }

        sc.close();
    }

    // Function to search the target in rotated sorted array
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // If no pivot found, the array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // If target lies in the left half (from start to pivot)
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot);
        }

        // If target lies in the right half (from pivot+1 to end)
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    // Function to find the pivot (largest element's index)
    public static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
        int mid = start + (end - start) / 2;

        // Case 1: If mid element is greater than next, mid is pivot
        if (mid < end && nums[mid] > nums[mid + 1]) return mid;

        // Case 2: If mid element is less than previous, previous is pivot
        if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

        // Case 3: Decide which half to search
        // ✅ Tutor's logic: If start >= mid, pivot must be in the left half
        if (nums[start] >= nums[mid]) {
            end = mid - 1;
        } else {
            // Otherwise, pivot lies in the right half
            start = mid + 1;
        }
    }

    // If no pivot is found, that means array is not rotated
    return -1;
    }

    // Standard binary search function
    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}

// //method 2 that i actually learned from chatgpt bacuase it gave a shorter code(leetcode solution)
//     public boolean search(int[] nums, int target) {
//         int start = 0;
//         int end = nums.length - 1;

//         while (start <= end) {
//             int mid = start + (end - start) / 2;

//             // Found the element
//             if (nums[mid] == target) return true;

//             // Duplicates handling — skip duplicates
//             if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
//                 start++;
//                 end--;
//             }

//             // Left half is sorted
//             else if (nums[start] <= nums[mid]) {
//                 if (nums[start] <= target && target < nums[mid]) {
//                     end = mid - 1;
//                 } else {
//                     start = mid + 1;
//                 }
//             }

//             // Right half is sorted
//             else {
//                 if (nums[mid] < target && target <= nums[end]) {
//                     start = mid + 1;
//                 } else {
//                     end = mid - 1;
//                 }
//             }
//         }

//         return false;
//     }

// Method 2 feels shorter because it's more compact — everything is done inside search().

// Method 1 is longer but more modular — ideal for clarity and reuse.

// Both are valid. Method 1 = Better for structured thinking. Method 2 = Better for coding interviews or quick implementation.



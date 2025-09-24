//===========================================================
// LeetCode 35 - Search Insert Position
// Date: 23/09/2025
// Link: https://leetcode.com/problems/search-insert-position/
// Tags: Array / Binary Search
// Approach: 
//   1) Linear Scan: O(n) - iterate to find first element >= target
//   2) Brute-Force / Nested Loop: O(n^2) - conceptual demonstration
//   3) Optimized Binary Search: O(log n) - efficient solution
// Time Complexity: O(n) linear, O(n^2) brute-force, O(log n) binary
// Space Complexity: O(1)
//===========================================================

class SearchInsertPosition {

    //--------------- Linear Scan Approach ----------------
    static int searchInsertLinear(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length; // target greater than all elements
    }

    //--------------- Brute-Force / Nested Loop ----------------
    static int searchInsertBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // nested loop to demonstrate brute-force
                if (nums[i] >= target) {
                    return i;
                } else if (i > 0 && nums[i - 1] < target && nums[i] > target) {
                    return i;
                }
            }
        }
        return n;
    }

    //--------------- Optimized Binary Search ----------------
    static int searchInsertBinary(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left; // insertion position
    }

    //--------------- Main Method for Testing ----------------
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println("Linear Scan: " + searchInsertLinear(nums, target));
        System.out.println("Brute-Force: " + searchInsertBruteForce(nums, target));
        System.out.println("Binary Search: " + searchInsertBinary(nums, target));
    }
}
// package LinearSearch_Revision;

// public class SearchInsert_1 {
    
// }

// 1. The Linear Search Mindset (what you already understand)

// If you scan left to right:

// If nums[i] == target, return i.

// If nums[i] > target, return i (since that’s where target should be inserted).

// If you reach the end and didn’t find it, return len(nums).

// This works fine — but it’s O(n) time. If nums is large (say, 10⁶ elements), scanning every element is slow.

// 2. Why Binary Search?

// Binary search works because:

// The array is sorted.

// Instead of checking every element, we repeatedly “halve” the search space.

// That gives us O(log n) time. For 10⁶ elements, that’s ~20 checks instead of 1,000,000. Huge difference.

// So the only reason we use binary search here is efficiency. Functionally, linear search and binary search give the same answer — but binary search is much faster.

// Got it — let’s slow down **even more** and focus on the most confusing bit:
// 👉 *Why do we return `left` after the binary search loop ends?*

// I’ll show you step by step **with just one example** so it’s super clear.

// ---

// ### Example

// `nums = [1, 3, 5, 6]`
// `target = 2` (not in the array)

// We want to find the index where `2` should be inserted.

// ---

// ### Step 1: Start

// ```
// left = 0, right = 3
// ```

// Array with indexes:

// ```
// index: 0   1   2   3
// value: 1   3   5   6
// ```

// ---

// ### Step 2: First mid

// ```
// mid = (0+3)//2 = 1
// nums[mid] = 3
// ```

// Compare target (2) with nums\[mid] (3):

// * 2 < 3 → target must be on the **left side**
// * So move right pointer: `right = mid - 1 = 0`

// Now:

// ```
// left = 0, right = 0
// ```

// ---

// ### Step 3: Next mid

// ```
// mid = (0+0)//2 = 0
// nums[mid] = 1
// ```

// Compare target (2) with nums\[mid] (1):

// * 2 > 1 → target must be on the **right side**
// * So move left pointer: `left = mid + 1 = 1`

// Now:

// ```
// left = 1, right = 0
// ```

// ---

// ### Step 4: Loop ends

// Loop condition is `while left <= right`.
// But now `left = 1` and `right = 0`, so loop stops.

// ---

// ### Final Answer

// At this point, `left = 1`.

// What does that mean?
// It means **target should go at index 1** (between `1` and `3`).
// And that’s exactly the correct answer. 🎯

// ---

// ### 🔑 Why always `left`?

// * If target is **smaller than everything** → loop ends with `left=0`.
// * If target is **bigger than everything** → loop ends with `left=len(nums)`.
// * If target fits **in between** → loop ends with `left` pointing exactly to that spot.

// That’s why we always return `left`.

// ---

// Would you like me to **make a small diagram** where I actually show arrows moving (`left →`, `right ←`) on the array step by step for this same example? It will literally show you how `left` lands on the insertion spot.


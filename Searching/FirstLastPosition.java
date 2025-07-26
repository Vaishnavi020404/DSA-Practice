// LeetCode Problem 34: Find First and Last Position of Element in Sorted Array
// Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Level: Medium
// Tags: Binary Search, Array

/*
🔍 Problem Summary:
Given an array of integers nums sorted in ascending order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].
The algorithm must run in O(log n) time.

🧠 Approach:
We use Binary Search to find:
1. The first occurrence of the target.
2. The last occurrence of the target.
This ensures O(log n) time complexity as required.

📈 Time Complexity:
O(log n) - because we perform binary search twice.

📌 Space Complexity:
O(1) - no extra space is used.

⚠️ TLE Issue Faced:
Originally, I got a TLE (Time Limit Exceeded) because of:
- Incorrect or infinite binary search loop (like not updating mid/start/end properly)
- Possibly used linear scan or recursive binary search with poor base cases
- **NOT** because of using `private`, `public`, or `static`. Those keywords just control access or class-level usage — they don't affect runtime performance.
*/




import java.util.Arrays;
public class FirstLastPosition {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 7;
        int[] result=searchRange(arr, target);
        System.out.println(Arrays.toString(result));
    }
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);
        if(ans[0]!= -1){
            ans[1] = search(nums, target, false);
        }
     
        return ans;
    }

    static int search(int[] nums, int target, boolean findStart) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (findStart) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    
}

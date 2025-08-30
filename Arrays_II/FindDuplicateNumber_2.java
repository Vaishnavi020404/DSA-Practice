//===========================================================
// LeetCode 287 - Find the Duplicate Number
// Date: 30/08/2025
// Link: https://leetcode.com/problems/find-the-duplicate-number/
// Tags: Array / Hashing
// Approach: 
//   1) Using HashMap to keep counts (works, O(n) time, O(n) space).
//   2) Using Floyd's Tortoise and Hare cycle detection (O(1) space) – can optimize, but okay to do later.
// Time Complexity: O(n) for HashMap approach
// Space Complexity: O(n) for HashMap approach
// Note: Floyd's Tortoise and Hare is optional for optimization; can learn later
//===========================================================

import java.util.HashMap;
import java.util.Scanner;

public class FindDuplicateNumber_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the array size (n + 1, numbers from 1 to n): ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //--------------- Processing Section ----------------
        int duplicateUsingMap = findDuplicateUsingHashMap(arr);

        //--------------- Output Section ----------------
        System.out.println("\nResult:");
        System.out.println("Duplicate number (using HashMap): " + duplicateUsingMap);
        System.out.println("Note: Floyd's Tortoise and Hare method can be used to optimize space, but can be learned later.");

        sc.close();
    }

    //===========================================================
    // Approach 1: Using HashMap to track counts
    // Returns the duplicate number
    //===========================================================
    static int findDuplicateUsingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);

            if (count >= 1) {
                return num; // duplicate found
            }

            map.put(num, count + 1);
        }

        return -1; // should not happen if input has a duplicate
    }

    //===========================================================
    // Approach 2: Floyd's Tortoise and Hare (Optional/Optimized)
    // Can be used to find the duplicate in O(1) space
    // Not implemented here; can learn and add later
    //===========================================================
}

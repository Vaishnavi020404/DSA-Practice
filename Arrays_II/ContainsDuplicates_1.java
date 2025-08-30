//===========================================================
// LeetCode 217 - Contains Duplicate
// Date: 30/08/2025
// Link: https://leetcode.com/problems/contains-duplicate/
// Tags: Hashing / Set
// Approach: 
//   1) Using HashSet for O(n) optimized solution.
//   2) Using HashMap to keep counts (works, but slightly more overhead).
// Time Complexity: O(n) for both approaches
// Space Complexity: O(n) for both approaches


//===========================================================

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicates_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the array size (can include duplicates): ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //--------------- Processing Section ----------------
        boolean resultUsingSet = containsDuplicatesUsingHashSet(arr);
        boolean resultUsingMap = containsDuplicatesUsingHashMap(arr);

        //--------------- Output Section ----------------
        System.out.println("\nResults:");
        System.out.println("Approach 1 (HashSet): " + resultUsingSet);
        System.out.println("Approach 2 (HashMap): " + resultUsingMap);

        sc.close();
    }

    //===========================================================
    // Approach 1: Using HashMap to track counts
    // Returns true if any element appears more than once
    //===========================================================
    static boolean containsDuplicatesUsingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);

            if (count >= 1) {
                return true; // duplicate found
            }

            map.put(num, count + 1);
        }

        return false; // no duplicates
    }

    //===========================================================
    // Approach 2: Using HashSet to track presence
    // Returns true if any element appears more than once
    //===========================================================
    static boolean containsDuplicatesUsingHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true; // duplicate found
            }
            set.add(num);
        }

        return false; // no duplicates
    }
}

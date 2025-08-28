// | Method           | Time Complexity | Space Complexity | Notes                               |
// | ---------------- | --------------- | ---------------- | ----------------------------------- |
// | Brute Force      | O(n²)           | O(1)             | Checks all pairs, slow for big n    |
// | HashMap (Optim.) | O(n)            | O(n)             | Stores seen numbers for O(1) lookup |

/*
---------------------------------------------------------------
 Program: Two Sum Problem (Brute Force vs HashMap Approaches)
 * 28 August, 2025
 * PLACEMENT ARRAY 4
 * TwoSum.java
 * LeetCode 1: Two Sum
 * Problem link: https://leetcode.com/problems/two-sum/

 Description:
   This program solves the classic "Two Sum" problem:
   -> Given an array of integers and a target value,
      find indices of pairs whose sum equals the target.

 Approaches Implemented:
   1. Brute Force (first pair only)
      - Nested loops check every possible pair.
      - Time Complexity: O(n^2)
      - Space Complexity: O(1)

   2. Brute Force (all pairs)
      - Same nested loops, but collect ALL valid pairs.

   3. HashMap (optimized, first pair only)
      - Uses HashMap to store numbers and indices.
      - Checks complement (target - current).
      - Time Complexity: O(n)
      - Space Complexity: O(n)
      - More efficient because it avoids re-checking pairs.

   4. HashMap (all pairs)
      - Extended version of HashMap method to collect ALL valid pairs.

 Notes on Doubts:
   - Brute force is not better than HashMap because O(n^2) grows very fast
     with large arrays, while HashMap stays O(n) on average.



---------------------------------------------------------------
*/

import java.util.*;

public class Two_Sum_4 {

    // 1. Brute Force - first pair
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // empty if no pair found
    }

    // 2. Brute Force - all pairs
    public static List<int[]> twoSumBruteForceAll(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    // 3. HashMap - first pair
    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 4. HashMap - all pairs
    public static List<int[]> twoSumHashMapAll(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                for (int index : map.get(complement)) {
                    result.add(new int[]{index, i});
                }
            }

            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        return result;
    }

    // Main Function - takes user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // Run all methods
        System.out.println("\nBrute Force (first pair): " + Arrays.toString(twoSumBruteForce(nums, target)));

        System.out.println("Brute Force (all pairs): ");
        for (int[] p : twoSumBruteForceAll(nums, target)) {
            System.out.println(Arrays.toString(p));
        }

        System.out.println("HashMap (first pair): " + Arrays.toString(twoSumHashMap(nums, target)));

        System.out.println("HashMap (all pairs): ");
        for (int[] p : twoSumHashMapAll(nums, target)) {
            System.out.println(Arrays.toString(p));
        }

        sc.close();
    }
}

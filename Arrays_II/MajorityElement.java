//===========================================================
// LeetCode 169 - Majority Element
// Date: 30/08/2025
// Link: https://leetcode.com/problems/majority-element/
// Tags: Hashing / Array
// Approach: 
//   1) Using HashMap to count frequency of each number
//      and find the one appearing more than n/2 times.
//   2) (Optional) Boyer-Moore Voting Algorithm can be used 
//      to optimize space to O(1), but HashMap is enough 
//      for fresher-level interviews.
// Time Complexity: O(n)
// Space Complexity: O(n)
//===========================================================

import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //--------------- Processing Section ----------------
        int majority = findMajorityElement(arr);

        //--------------- Output Section ----------------
        System.out.println("\nMajority Element: " + majority);

        sc.close();
    }

    //===========================================================
    // Approach 1: Using HashMap to count frequency
    // Returns the element appearing more than n/2 times
    //===========================================================
    static int findMajorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        // Check which element has count > n/2
        for (int num : nums) {
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1; // should not happen as per problem constraints
    }

    //===========================================================
    // Approach 2 (Optional): Boyer-Moore Voting Algorithm
    // Can optimize space to O(1) but HashMap is enough for fresher
    //===========================================================
}

//===========================================================
// LeetCode 3 - Longest Substring Without Repeating Characters
// Date: 31/08/2025,solved again on 26/06/2026
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Tags: Hashing / Sliding Window / Set
// Approach Summary & Notes for Revision:
//   1) The core problem: Find the length of the longest substring WITHOUT repeating characters.
//      - We are NOT asked to return the substring itself, only the length.
//      - Why? Because the current substring may shrink due to duplicates, 
//        but a previous substring could have been longer. We must keep track of the maximum.
//   2) Use HashSet to track characters in the current substring for O(1) lookups.
//   3) Use two pointers (start, i) to manage the sliding window:
//        - 'start' points to the beginning of the current substring
//        - 'i' points to the current character being processed
//   4) When a duplicate is found, remove characters from the start until the duplicate is gone.
//   5) Calculate the length of the current substring as (i - start + 1):
//        - '+1' because both start and i are inclusive
//   6) Keep updating 'longest' to store the maximum length seen so far.
//   7) At the end, return 'longest'.
// Time Complexity: O(n) - each character is added and removed at most once
// Space Complexity: O(n) - for the HashSet
//===========================================================

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the string: ");
        String str = sc.nextLine();

        //--------------- Processing Section ----------------
        int maxLength = lengthOfLongestSubstring(str);

        //--------------- Output Section ----------------
        System.out.println("\nLength of longest substring without repeating characters: " + maxLength);

        sc.close();
    }

    //===========================================================
    // Approach: Using HashSet and Sliding Window
    // Returns the length of the longest substring without duplicates
    //===========================================================
    static int lengthOfLongestSubstring(String str) {
        HashSet<Character> set = new HashSet<>();  // stores characters in current substring
        int start = 0;      // start index of current substring
        int longest = 0;    // maximum length found

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // remove characters from start until 'c' is not a duplicate
            while (set.contains(c)) {
                set.remove(str.charAt(start));
                start++;
            }

            set.add(c);
            longest = Math.max(longest, i - start + 1); // update maximum length
        }

        return longest; // return the length of the longest substring
    }
}

//===========================================================
// LeetCode 392 - Is Subsequence
// Date: 20/12/2025
// Link: https://leetcode.com/problems/is-subsequence/
// Tags: String, Two Pointers
// Approach:
//   1) Use two pointers: i for string s, j for string t.
//   2) Traverse string t completely.
//   3) If characters match, move pointer i.
//   4) Always move pointer j.
//   5) If i reaches the length of s, s is a subsequence of t.
// Time Complexity: O(n) where n = length of t
// Space Complexity: O(1)
//===========================================================

import java.util.Scanner;

public class IsSubsequence {

    // Function to check if s is a subsequence of t
    public static boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        // Traverse both strings
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move s pointer only on match
            }
            j++; // always move t pointer
        }

        // If all characters of s are matched
        return i == s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string t: ");
        String t = sc.nextLine();

        // Call function
        boolean result = isSubsequence(s, t);

        // Output result
        System.out.println("Is s a subsequence of t? " + result);

        sc.close();
    }
}

// Notes:
// 1) Pointer i moves only when characters match.
// 2) Pointer j always moves to scan the entire string t.
// 3) Order is preserved automatically because we never move backwards.
// 4) Hashing is useless here because subsequence depends on order.
// 5) Completion is checked using i == s.length(), not last index.

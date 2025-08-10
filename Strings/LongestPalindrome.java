/*
 * Date: 10 August 2025
 * Problem: 5. Longest Palindromic Substring
 * LeetCode Link: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Approach Used:
 * - Expand Around Center
 * - For each character (and the gap between characters), treat it as a palindrome center.
 * - Expand outward while characters match.
 * - Track the longest palindrome found.
 *
 * Time Complexity: O(n^2)  -> n = length of the string
 *   - For each of n centers, expanding can take O(n) in the worst case.
 * Space Complexity: O(1)  -> Only a few integer variables are used for tracking indices.
 */

import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result=longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }

    static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expandAroundCenter(s, i, i);       // Odd length palindrome
            int[] even = expandAroundCenter(s, i, i + 1); // Even length palindrome

            int[] longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;

            if (longer[1] - longer[0] > end - start) {
                start = longer[0];
                end = longer[1];
            }
        }

        return s.substring(start, end + 1);
    }

    static int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[] {left + 1, right - 1};
    }
}


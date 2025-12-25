// Date: Sunday, August 24, 2025, solved again on 25/12/25
// Problem: Find the Index of the First Occurrence in a String (LeetCode 28)
// Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
//
// Description:
// Implement the function `strStr(haystack, needle)` using the brute force approach.
// Given two strings, `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`,
// or -1 if `needle` is not part of `haystack`.
//
// Rules:
// 1. If `needle` is empty, return 0.
// 2. Compare all possible substrings of `haystack` with `needle`.
// 3. Return the first index if match is found, else -1.
// 4. We are using the brute force method (later optimized with KMP).
//
// Approach (Brute Force):
// 1. Loop through each possible starting index in `haystack` where `needle` could fit.
// 2. For each starting index, compare character by character with `needle`.
// 3. If all characters match, return the starting index.
// 4. If no match is found after scanning, return -1.
//
// Time Complexity: O(N * M) — where N = length of haystack, M = length of needle
// Space Complexity: O(1) — only uses variables, no extra data structures



import java.util.*;
class FirstOccurrenceInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter haystack: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle: ");
        String needle = sc.nextLine();

        // Call function
        int result = strStr(haystack, needle);

        // Print result
        System.out.println("First occurrence index: " + result);
    }

   //Brute-Force method
    static int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;

    int i = 0, j = 0;

    while (i < haystack.length()) {
        if (haystack.charAt(i) == needle.charAt(j)) {
            i++;
            j++;
            if (j == needle.length()) return i - j;
        } else {
            i = i - j + 1; // go to next start
            j = 0;         // restart needle
        }
    }
    return -1;
    }

    //USING KMP OR RABIN-KARP ALGORITHM

    
}

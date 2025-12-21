// Date: 21/12/25
// Problem: Ransom Note (LeetCode 383)
// Link: https://leetcode.com/problems/ransom-note/
//
// Description:
// Given two strings ransomNote and magazine, return true if ransomNote
// can be constructed from magazine, false otherwise.
// Each character in magazine can only be used once.
//
// Approaches:
// 1. Optimized (Frequency Array)
//    - Count characters from magazine
//    - Decrease count while scanning ransomNote
//    - If any count goes below zero → false
//    - Time: O(N), Space: O(1)
//
// 2. HashMap Method
//    - Store frequency of characters from magazine
//    - Decrement while scanning ransomNote
//    - Time: O(N), Space: O(N)
//
// Note:
// - Optimized solution is preferred in interviews when input is lowercase letters.

import java.util.*;

public class RansomNoteCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ransom note: ");
        String ransomNote = sc.nextLine();

        System.out.print("Enter magazine: ");
        String magazine = sc.nextLine();

        System.out.println("\nCan construct ransom note?\n");

        System.out.println("Optimized (Frequency Array): "
                + canConstructOptimized(ransomNote, magazine));

        System.out.println("HashMap Method:              "
                + canConstructHashMap(ransomNote, magazine));

        sc.close();
    }

    // --------------------------------------------------
    // 1. Optimized method using Frequency Array
    // --------------------------------------------------
    public static boolean canConstructOptimized(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            if (c < 'a' || c > 'z') continue; // safety
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (c < 'a' || c > 'z') return false;

            if (freq[c - 'a'] == 0) return false;
            freq[c - 'a']--;
        }

        return true;
    }

    // --------------------------------------------------
    // 2. HashMap method
    // --------------------------------------------------
    public static boolean canConstructHashMap(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}

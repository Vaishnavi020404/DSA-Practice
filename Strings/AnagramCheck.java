// Date: 21/8/25
// Problem: Valid Anagram (LeetCode 242)
// Link: https://leetcode.com/problems/valid-anagram/
//
// Description:
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An anagram is a word formed by rearranging the letters of another word,
// using all the original letters exactly once.
//
// Approaches:
// 1. BruteForce (Sorting)
//    - Convert both strings to char arrays.
//    - Sort and compare.
//    - Time: O(N log N), Space: O(N).
//
// 2. Optimized (Frequency Array)
//    - Use an integer array of size 26 for lowercase letters.
//    - Increment count for s, decrement for t.
//    - If all counts are zero → strings are anagrams.
//    - Time: O(N), Space: O(1).
//
// 3. HashMap Method
//    - Store character frequencies in a HashMap.
//    - Add for s, subtract for t.
//    - Check all values are zero.
//    - Time: O(N), Space: O(N).
//
// Note:
// - Strings are immutable in Java, so in-place checks are not possible.
// - Optimized frequency-array method is fastest for lowercase-only input.
import java.util.*;   // for Scanner, Arrays, HashMap

public class AnagramCheck {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        System.out.println("\nChecking if \"" + s + "\" and \"" + t + "\" are anagrams...");

        System.out.println("BruteForce (Sorting) Method: " + isAnagramBruteForce(s, t));
        System.out.println("Optimized (Frequency Array) Method: " + isAnagramOptimized(s, t));
        System.out.println("HashMap Method: " + isAnagramHashMap(s, t));

        sc.close();
    }

    // 1. BruteForce method using Sorting
    public static boolean isAnagramBruteForce(String s, String t) {
        if (s.length() != t.length()) return false;

        // Convert both strings to char arrays
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // Sort both arrays
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare sorted arrays
        return Arrays.equals(sArr, tArr);
    }

    // 2. Optimized method using Frequency Array
    public static boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // for 26 letters (assuming only lowercase English)

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // increase for s
            count[t.charAt(i) - 'a']--; // decrease for t
        }

        for (int val : count) {
            if (val != 0) return false; // mismatch in frequency
        }

        return true;
    }

    // 3. HashMap method
    public static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
        }

        for (int val : map.values()) {
            if (val != 0) return false;
        }

        return true;
    }

   
}

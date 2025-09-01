//===========================================================
// LeetCode 242 - Valid Anagram (Two Methods)
// Date: 01/09/2025
// Tags: HashMap / Sorting / Frequency Array / String
// Approach Summary & Notes for Revision:
//   Method 1: HashMap Counting (Your Original Method)
//     - Count frequency of each character in first string
//     - Subtract frequency using second string
//     - If all counts are zero → anagram
//     - Time: O(n), Space: O(n) for HashMap
//   Method 2: Sorting
//     - Sort both strings
//     - Compare sorted strings
//     - Time: O(n log n), Space: O(n)
//===========================================================

import java.util.*;

public class ValidAnagram_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter first string:");
        String s = sc.nextLine();

        System.out.println("Enter second string:");
        String t = sc.nextLine();

        //--------------- Processing Section ----------------
        boolean result1 = isAnagramHashMap(s, t);
        boolean result2 = isAnagramSort(s, t);

        //--------------- Output Section ----------------
        System.out.println("\nUsing HashMap Counting Method: " + result1);
        System.out.println("Using Sorting Method: " + result2);

        sc.close();
    }

    //===========================================================
    // Method 1: HashMap Counting (Original Method)
    //===========================================================
    static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count chars in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract chars in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        // Verify all counts are zero
        for (int count : map.values()) {
            if (count != 0) return false;
        }

        return true;
    }

    //===========================================================
    // Method 2: Sorting
    //===========================================================
    static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}

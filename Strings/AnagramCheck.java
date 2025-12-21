// Date: 21/8/25
// Problem: Valid Anagram (LeetCode 242),solved again on 21/12/25
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

//     int[] count = new int[26];  // All zeros
// count = [0, 0, 0, 0, 0, ...] // 26 zeros
//          a  b  c  d  e  ...
//        index 0, 1, 2, 3, 4...
// ```

// ---

// ### **Step 2: Process string `s = "cat"`**

// **Character 'c':**
// - `'c' - 'a'` = What position is 'c' in the alphabet? → 2 (because a=0, b=1, c=2)
// - `count[2]++` → increase the count at position 2
// - `count = [0, 0, 1, 0, ...]`

// **Character 'a':**
// - `'a' - 'a'` = 0
// - `count[0]++`
// - `count = [1, 0, 1, 0, ...]`

// **Character 't':**
// - `'t' - 'a'` = 19 (because t is the 19th letter after a)
// - `count[19]++`
// - `count = [1, 0, 1, 0, 0, ..., 1, ...]`
// ```
//           a  b  c             t

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
// map.merge(c, 1, Integer::sum)

// If key c doesn't exist → insert it with value 1
// If key c exists → add 1 to its current value
// Basically: map.put(c, map.getOrDefault(c, 0) + 1) but cleaner

// map.computeIfPresent(c, (key, val) -> val > 1 ? val - 1 : null)

// Only runs if key c exists
// If value > 1 → decrement it by 1
// If value = 1 → return null (which removes the key)
// Basically: decrements the count or removes the key if count reaches 0


// ## **How does returning `null` remove the key?**

// From the Java docs for `computeIfPresent`:
// > "If the function returns null, the mapping is removed"

// It's built into the method's behavior. When your remapping function returns `null`, `computeIfPresent` automatically calls `map.remove(key)` for you.

// ```java
// // These are equivalent:
// map.computeIfPresent(c, (key, val) -> val > 1 ? val - 1 : null);

// // Same as:
// if (map.containsKey(c)) {
//     int val = map.get(c);
//     if (val > 1) {
//         map.put(c, val - 1);
//     } else {
//         map.remove(c);  // <-- null triggers this
//     }
// }
// ```

// ## **What is `Integer::sum`?**

// It's a **method reference** to `Integer.sum(a, b)`, which just adds two integers.

// ```java
// // These are equivalent:
// map.merge(c, 1, Integer::sum);
// map.merge(c, 1, (oldVal, newVal) -> oldVal + newVal);
// map.merge(c, 1, (oldVal, newVal) -> Integer.sum(oldVal, newVal));
// ```

// `merge` takes 3 parameters:
// 1. Key (`c`)
// 2. Default value if key doesn't exist (`1`)
// 3. Function to combine old value + new value (`Integer::sum`)

// So `Integer::sum` is just shorthand for adding the values together!
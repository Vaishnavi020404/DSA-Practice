//===========================================================
// LeetCode 28 - Find the Index of the First Occurrence in a String
// Date: 23/09/2025
// Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
// Tags: String / Substring
// Approach: 
//   1) Use built-in Java method indexOf
//   2) Manual substring comparison
// Time Complexity: O(n*m) for manual, O(n) for indexOf
// Space Complexity: O(1)
//===========================================================
import java.util.Scanner;

public class FindFirstOccurrenceInString2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the haystack string: ");
        String haystack = sc.nextLine();

        System.out.println("Enter the needle string: ");
        String needle = sc.nextLine();

        //--------------- Processing Section ----------------
        int idxBuiltIn = strStrBuiltIn(haystack, needle);
        int idxManual = strStrManual(haystack, needle);

        //--------------- Output Section ----------------
        System.out.println("\nResults:");
        System.out.println("Built-in indexOf Approach: " + idxBuiltIn);
        System.out.println("Manual Substring Comparison Approach: " + idxManual);

        sc.close();
    }

    // Using built-in method
    static int strStrBuiltIn(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Manual substring comparison
    static int strStrManual(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
// 🔹 What .substring() does:

// .substring(startIndex, endIndex) returns a new string that is a portion of the original string.

// It starts at startIndex (inclusive) and goes up to endIndex (exclusive).

// 🔹 Syntax:
// String str = "hello";
// String sub = str.substring(1, 4);  // from index 1 to 3
// System.out.println(sub);           // "ell"


// ✅ Explanation:

// str[1] = 'e', str[2] = 'l', str[3] = 'l'

// Index 4 is excluded.



// 🔹 What happens if you don’t use .equals() and use == instead:
// if (haystack.substring(i, i + m) == needle) {
//     return i;
// }


// == in Java does NOT check the content of strings.

// It checks if the two string references point to the exact same object in memory.

// Usually, haystack.substring(i, i + m) creates a new string object, so even if it has the same characters as needle, == will often be false.

// ✅ Example:

// String a = "hello";
// String b = new String("hello");

// System.out.println(a == b);      // false → different objects
// System.out.println(a.equals(b)); // true  → same content


// So, if you use ==, your function will fail most of the time, even if the substring matches needle.
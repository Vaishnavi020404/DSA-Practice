//===========================================================
// LeetCode 58 - Length of Last Word
// Date: 24/01/2026
// Link: https://leetcode.com/problems/length-of-last-word/

// Tags: String / Two Pointers
//
// Pattern Used: Reverse Scan / Count Until Condition
//
// Approach:
// ----------------------------------------------------------
// 1) Start scanning from the end of the string.
// 2) Skip trailing spaces.
// 3) Count consecutive letters until a space or start of string.
// 4) Return the count.
//
// Time Complexity: O(n)
// Only one backward pass through the string.
// Each character is checked at most twice (skip spaces + count letters).
// Space Complexity: O(1)
// No extra array or split operation.
// Only integer counters are used.
//===========================================================
import java.util.Scanner;

public class LengthLastWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        //--------------- Processing Section ----------------
        int length = lengthOfLastWord(input);

        //--------------- Output Section ----------------
        System.out.println("Length of last word: " + length);

        sc.close();
    }

    //===========================================================
    // Method: lengthOfLastWord
    // Pattern: Reverse Scan / Count Until Condition
    // Returns the length of the last word in the string
    //===========================================================
    static int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count letters in last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}

//===========================================================
// LeetCode 125 - Valid Palindrome (Two Methods)
// Date: 01/09/2025
// Tags: Two Pointers / String / Regex / Character Methods
// Approach Summary & Notes for Revision:
//   Method 1: Two Pointers + Character.isLetterOrDigit
//     - Skip non-alphanumeric characters using built-in Character methods
//     - Compare characters ignoring case
//   Method 2: Regex Preprocessing
//     - Remove all non-alphanumeric characters using regex
//     - Convert to lowercase
//     - Compare using two pointers
//===========================================================

import java.util.Scanner;

public class ValidPalindrome_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the string to check for palindrome:");
        String s = sc.nextLine();

        //--------------- Processing Section ----------------
        boolean isPalindrome1 = checkPalindromeCharMethod(s);
        boolean isPalindrome2 = checkPalindromeRegex(s);

        //--------------- Output Section ----------------
        System.out.println("\nUsing Character.isLetterOrDigit method: " + isPalindrome1);
        System.out.println("Using Regex preprocessing method: " + isPalindrome2);

        sc.close();
    }

    //===========================================================
    // Method 1: Two Pointers + Character.isLetterOrDigit
    //===========================================================
    static boolean checkPalindromeCharMethod(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // Skip non-alphanumeric characters from start
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;

            // Skip non-alphanumeric characters from end
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    //===========================================================
    // Method 2: Preprocess string using Regex + Two Pointers
    //===========================================================
    static boolean checkPalindromeRegex(String s) {
        // Remove all non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Date: Friday, August 8, 2025
// LeetCode Problem 125: Valid Palindrome
// Problem Link: https://leetcode.com/problems/valid-palindrome/
// Description: Checks if a string is a palindrome, considering only alphanumeric characters and ignoring case.
// My first approach: This method first filters all alphanumeric characters into a new string,
// then performs a standard palindrome check on that new string.

// Optimized approach: This solution uses the two-pointer technique to check for a palindrome in-place,
// without creating any new strings. This is more memory-efficient.  

// Time complexity: O(n), where n is the length of the string.
// Space complexity: O(n), where n is the length of the string.

// I have let the comments in the method given by chatpgt  STAY for my furutre revision

//Note:In the context of the "Valid Palindrome" problem, the word "valid" means that a character is either a letter (a-z, A-Z) or a number (0-9).
// The problem asks you to ignore all other characters, which are considered "invalid." This includes things like spaces, punctuation (., ,, :), and symbols (!, ?, @).
// So, when the problem asks if a string is a "valid palindrome," it means you should only look at the alphanumeric characters to determine if it reads the same forwards and backwards.

import java.util.*;
public class VALIDPalindromeChecker {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it's a valid palindrome:");
        String input = scanner.nextLine();
System.out.println("Result (brute-force approach): " + isPalindrome(input));
System.out.println("Result (optimized approach): " + isPalindrome2(input));

        
    }

    
    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                char ch = s.charAt(i);
                sb.append(ch);
            }
        }
        
        if (sb.length() == 0) {
            return true;
        }

        int start = 0;
        int end = sb.length() - 1;
        
        while (start < end) {
            if (sb.charAt(start) == sb.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome2(String s) {
        // Initialize two pointers, one at the beginning and one at the end of the string.
        int start = 0;
        int end = s.length() - 1;

        // The main loop continues as long as the pointers haven't met or crossed.
        while (start < end) {
            // Move the start pointer inward until it points to an alphanumeric character.
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            // Move the end pointer inward until it points to an alphanumeric character.
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            
            // Now, both pointers are on valid alphanumeric characters.
            // Compare them case-insensitively. If they don't match, it's not a palindrome.
            if (start < end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            // Move both pointers inward to check the next pair of valid characters.
            start++;
            end--;
        }

        // If the loop completes without finding a mismatch, the string is a palindrome.
        return true;
    }

   
}
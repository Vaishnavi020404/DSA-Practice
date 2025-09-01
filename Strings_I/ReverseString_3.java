//===========================================================
// LeetCode 344 - Reverse String (User Inputs Characters One by One)
// Date: 01/09/2025
// Link: https://leetcode.com/problems/reverse-string/
// Tags: Two Pointers / Array / In-Place / User Input
// Approach Summary & Notes for Revision:
//   1) The core problem: Reverse the given character array in-place.
//   2) Take input one character at a time from the user to form the array.
//   3) Use two pointers (left, right):
//        - 'left' starts at index 0
//        - 'right' starts at last index (s.length - 1)
//   4) Swap characters at left and right.
//   5) Move pointers towards the center (left++, right--).
//   6) Stop when left >= right (all characters reversed).
// Time Complexity: O(n) - each character is visited once
// Space Complexity: O(1) - in-place, no extra space
//===========================================================

import java.util.Arrays;
import java.util.Scanner;

public class ReverseString_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        char[] s = new char[n];
        System.out.println("Enter each character one by one:");

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            // Take the first character of the input
            s[i] = input.charAt(0);
        }

        //--------------- Processing Section ----------------
        reverseString(s);

        //--------------- Output Section ----------------
        System.out.println(Arrays.toString(s)); // prints reversed array

        sc.close();
    }

    //===========================================================
    // Approach: Using Two Pointers
    // Reverses the char array in-place
    //===========================================================
    static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters at left and right
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move pointers towards center
            left++;
            right--;
        }
    }
}

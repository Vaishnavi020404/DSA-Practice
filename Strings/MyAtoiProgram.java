// Date: Tuesday, August 20, 2025
// Problem: String to Integer (atoi) (LeetCode 8)
// Link: https://leetcode.com/problems/string-to-integer-atoi/

// Description:
// Implement a function `myAtoi` that converts a string to a 32-bit signed integer.
// Rules:
// 1. Ignore leading/trailing spaces.
// 2. Optional sign '+' or '-'.
// 3. Read digits until a non-digit character is found.
// 4. Clamp the result within [-2^31, 2^31 - 1] if overflow occurs.
// 5. Return the resulting integer.

// Approach:
// 1. Skip leading spaces manually (avoid trim() for efficiency).
// 2. Check for optional sign at the current index.
// 3. Iterate through digits, building the number step by step.
// 4. Check for overflow before multiplying/adding to prevent runtime errors.
// 5. Apply the sign at the end and return the result.

// Time Complexity: O(N) — single pass through the string
// Space Complexity: O(1) — only variables used, no extra arrays/strings

import java.util.Scanner;

public class MyAtoiProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to convert: ");
        String input = sc.nextLine();

        int result = myAtoi(input);
        System.out.println("Converted integer: " + result);

    }

    public static int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, num = 0;

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;

        // Handle sign
        if (i < n && s.charAt(i) == '-') { sign = -1; i++; }
        else if (i < n && s.charAt(i) == '+') i++;

        // Read digits and build number
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            // Overflow check
            if (num > (Integer.MAX_VALUE - digit) / 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }

    
}

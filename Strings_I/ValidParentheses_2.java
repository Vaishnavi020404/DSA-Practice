//===========================================================
// LeetCode 20 - Valid Parentheses
// Date: 01/09/2025
// Link: https://leetcode.com/problems/valid-parentheses/
// Tags: Stack / String / Brackets Matching
// Approach Summary & Notes for Revision:
//   1) The core problem: Check if the given string of brackets is VALID.
//      - A string is valid if every opening bracket has a corresponding closing bracket
//        in the correct order.
//   2) Use Stack to track opening brackets.
//   3) Traverse the string character by character:
//        - If it's an opening bracket '(', '[', '{' → push onto stack.
//        - If it's a closing bracket ')', ']', '}' → check the top of the stack:
//             • If stack is empty → invalid
//             • If top doesn't match corresponding opening → invalid
//             • Else → pop the matching opening from stack
//   4) After processing all characters:
//        - If stack is empty → all brackets matched → valid
//        - If stack is not empty → unmatched opening brackets → invalid
// Time Complexity: O(n) - each character is pushed/popped at most once
// Space Complexity: O(n) - for the stack storing opening brackets
//===========================================================

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        //--------------- Input Section ----------------
        System.out.println("Enter the sequence of parenthesis: ");
        String str = sc.nextLine();

        //--------------- Processing Section ----------------
        boolean isValid = isValidParentheses(str);

        //--------------- Output Section ----------------
        System.out.println(isValid); // prints true or false

        sc.close();
    }

    //===========================================================
    // Approach: Using Stack
    // Returns true if the string has valid parentheses
    //===========================================================
    static boolean isValidParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            // Step 1: Push opening brackets
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            // Step 2: Handle closing brackets
            else if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') return false;
                st.pop();
            } else if (c == ']') {
                if (st.isEmpty() || st.peek() != '[') return false;
                st.pop();
            } else if (c == '}') {
                if (st.isEmpty() || st.peek() != '{') return false;
                st.pop();
            }
        }

        // Step 3: In the end, stack must be empty
        return st.isEmpty();
    }
}

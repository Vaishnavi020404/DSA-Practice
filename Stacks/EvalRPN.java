// LeetCode 150 - Evaluate Reverse Polish Notation
// Date: 19/09/2025
// Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Tags: Stack / String / Math / Simulation
// Approach:
//   1) Use a stack to store operands
//   2) Iterate through each token:
//        - If token is an operator (+, -, *, /):
//            a) Pop the top two elements from the stack
//            b) Apply the operation
//            c) Push the result back onto the stack
//        - If token is a number, push it onto the stack
//   3) After processing all tokens, the stack will contain the final result
// Time Complexity: O(n) where n = number of tokens
// Space Complexity: O(n) for the stack

import java.util.*;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" : {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-" : {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*" : {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/" : {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }

        return stack.pop();
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tokens separated by space (RPN expression):");
        String[] tokens = sc.nextLine().split(" ");

        EvalRPN solution = new EvalRPN();
        int result = solution.evalRPN(tokens);

        System.out.println("Result: " + result);

        sc.close();
    }
}

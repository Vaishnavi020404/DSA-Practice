// LeetCode 71 - Simplify Path
// Date: 05/02/2026
// Link: https://leetcode.com/problems/simplify-path/
// Tags: Stack / String / Simulation
// Approach:
//   1) Take the absolute path as user input
//   2) Split the path using "/" to get directory tokens
//   3) Use a stack (Deque) to store valid directory names
//   4) Traverse each token:
//        - If token is empty "" or "." → ignore
//        - If token is ".." → pop from stack if not empty
//        - Else → push the directory name into stack
//   5) Build the simplified path by joining stack elements with "/"
//   6) If stack is empty, return "/"
// Time Complexity: O(n), where n = length of the path
// Space Complexity: O(n), for the stack

import java.util.*;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        return result.toString();
    }

    // Main method for user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter absolute Unix path:");
        String path = sc.nextLine();

        String simplifiedPath = simplifyPath(path);
        System.out.println("Simplified Path: " + simplifiedPath);

        sc.close();
    }
}

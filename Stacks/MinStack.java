// LeetCode 155 - Min Stack
// Date: 19/09/2025
// Link: https://leetcode.com/problems/min-stack/
// Tags: Stack / Design / O(1) Minimum Retrieval
// Approach:
//   1) Use two stacks: 
//        - stack: to store all elements
//        - minStack: to store the minimums
//   2) push(val): push val onto stack. If minStack is empty or val <= minStack.peek(), also push to minStack
//   3) pop(): pop from stack. If popped value equals minStack.peek(), also pop from minStack
//   4) top(): return stack.peek()
//   5) getMin(): return minStack.peek()
// Time Complexity: O(1) for all operations
// Space Complexity: O(n) for stack + minStack

import java.util.*;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
    }

    public void pop() {
        if (!stack.isEmpty() && minStack.peek().equals(stack.peek())) minStack.pop();
        if (!stack.isEmpty()) stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Hardcoded test case (LeetCode style)
        String[] operations = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        int[][] params = {{},{-2},{0},{-3},{},{},{},{}};

        List<String> output = new ArrayList<>();
        MinStack obj = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MinStack":
                    obj = new MinStack();
                    output.add("null");
                    break;
                case "push":
                    obj.push(params[i][0]);
                    output.add("null");
                    break;
                case "pop":
                    obj.pop();
                    output.add("null");
                    break;
                case "top":
                    output.add(String.valueOf(obj.top()));
                    break;
                case "getMin":
                    output.add(String.valueOf(obj.getMin()));
                    break;
            }
        }

        // Print LeetCode-style output
        System.out.println(output);
    }
}





// We use <= when pushing to minStack because the minimum value can appear multiple times.
// If we only use <, then when we pop one of the duplicate minimums, getMin() will give the wrong answer, because the minStack no longer has that value.
// Example:
// Push 5 → min = 5
// Push 3 → min = 3
// Push 3 → if we use <, minStack won’t add this second 3

// Pop → minStack loses the only 3 → getMin() now wrongly says 5
// Using <= ensures every occurrence of the minimum is tracked, so getMin() always works.





// ### 1️⃣ Primitive types vs Objects in Java

// In Java:

// * **Primitive types** (`int`, `double`, `char`, etc.) store the **actual value** directly.

//   ```java
//   int a = 5;
//   int b = 5;
//   System.out.println(a == b); // true → checks value directly
//   ```

// * **Objects** (like `Integer`, `String`, etc.) store a **reference (pointer)** to the memory location where the actual data is.

//   ```java
//   Integer a = new Integer(5); 
//   Integer b = new Integer(5);
//   System.out.println(a == b);      // false → different memory locations
//   System.out.println(a.equals(b)); // true  → values are equal
//   ```

// ---

// ### 2️⃣ What `==` actually does for objects

// * `==` compares **references**, i.e., are these two references pointing to the **exact same object in memory**?
// * If yes → `true`
// * If no → `false`, even if the actual numbers inside the objects are equal.

// So:

// ```java
// Integer x = new Integer(10);
// Integer y = new Integer(10);

// System.out.println(x == y);      // false, two different objects
// System.out.println(x.equals(y)); // true, same value inside
// ```

// ---

// ### 3️⃣ Why this matters in `MinStack`

// * `stack` stores your pushed `Integer` objects.
// * `minStack` stores **some of the same numbers**, but often as **different Integer objects**.

// Example:

// ```java
// stack = [512, -1024, -1024, 512]       // Integer objects
// minStack = [512, -1024, -1024]         // different Integer objects for same values
// ```

// * Now, `stack.peek()` gives a **new 512 object**.
// * `minStack.peek()` has the **old 512 object** stored earlier.

// If you do `stack.peek() == minStack.peek()`:

// * It checks **are they literally the same object**.
// * They are not → `false`.
// * Your minStack fails to pop → `getMin()` gives wrong value.

// If you do `stack.peek().equals(minStack.peek())`:

// * It checks **do they have the same value**.
// * They do → `true`.
// * minStack pops correctly → `getMin()` works.

// ---

// ### 4️⃣ Quick mental model

// Think of it like **two separate coins with the same face**:

// * `==` asks: *Are these literally the same coin?* → No, they are different coins.
// * `.equals()` asks: *Do these coins have the same face value?* → Yes, both show “5”.

// In `MinStack`, we care about **the face value** (number), not whether it’s the exact same object in memory.

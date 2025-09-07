//===========================================================
// LeetCode 50 - Pow(x, n)
// Date: 06/09/2025
// Link: https://leetcode.com/problems/powx-n/
// Tags: Recursion / Divide and Conquer / Math
// Approach: 
//   1) Handle negative exponents: x^(-n) = (1/x)^n
//   2) Use Recursion with Divide & Conquer (Exponentiation by Squaring)
//   3) If exponent is even → (x^(n/2))^2
//   4) If exponent is odd  → (x^(n/2))^2 * x
// Time Complexity: O(log n)
// Space Complexity: O(log n) (due to recursion stack)
//===========================================================

import java.util.Scanner;

public class PowerofX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter base (x): ");
        double x = sc.nextDouble();

        System.out.println("Enter exponent (n): ");
        int n = sc.nextInt();

        //--------------- Processing Section ----------------
        double result = myPow(x, n);

        //--------------- Output Section ----------------
        System.out.println("\nResult: " + result);

        sc.close();
    }

    //===========================================================
    // Function: myPow
    // Purpose : Handles negative exponents and calls fastPow
    //===========================================================
    public static double myPow(double x, int n) {
        long N = n; // use long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    //===========================================================
    // Function: fastPow
    // Purpose : Recursive divide & conquer power calculation
    //===========================================================
    private static double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half; // even exponent
        } else {
            return half * half * x; // odd exponent
        }
    }
}
// ---

// # ⚡ Quick Glance Notes for `myPow`

// 1. **Goal:** Find $x^n$ (x to the power n).

// 2. **Normal (slow) way:**
//    Multiply again and again. Example:
//    $2^{10} = 2*2*2*...$ (10 times) → **too slow** for big n.

// 3. **Smart (fast) way:**

//    * Cut the problem in **half** every time.
//    * **Reuse** the result by squaring.
//    * Works in **O(log n)** steps (super fast).

// ---

// ### ⚙️ How Code Works

// * **Step 1: Handle negatives**
//   If n is negative → change to positive, and make x = 1/x.
//   (Because $x^{-n} = (1/x)^n$)

// * **Step 2: Recursive function (`fastPow`)**

//   * If n == 0 → return 1 (base case).
//   * Find `half = fastPow(x, n/2)`.
//   * If n is **even** → answer = `half * half`.
//   * If n is **odd** → answer = `half * half * x`.

// ---

// ### 📒 Example 1: $2^4$

// * `half = 2^2 = 4`
// * even → `4*4 = 16`

// ### 📒 Example 2: $2^3$

// * `half = 2^1 = 2`
// * odd → `2*2*2 = 8`

// ### 📒 Example 3: $2^{-3}$

// * Convert → $(1/2)^3 = 0.5^3$
// * Do same steps → answer = 0.125

// ---

// ### 🔑 One-Line Formula

// * If **even:** $x^n = (x^{n/2})^2$
// * If **odd:** $x^n = (x^{n/2})^2 * x$

// ---

// That’s it bro — just **3 rules**:
// 👉 Cut in half → Square it → Multiply x if odd.

// myPow(2, -3)  
// → fastPow(0.5, 3)  
//     → fastPow(0.5, 1)  
//         → fastPow(0.5, 0) = 1  
//         → returns 0.5  
//     → returns 0.125



// Date:November 25,2025
// Problem: Number of Steps to Reduce a Number to Zero (LeetCode 1342)
// Description:
// Given an integer num, return the number of steps to reduce it to zero.
//
// Rules:
// - If the number is EVEN → divide by 2
// - If the number is ODD  → subtract 1
//
// Approach (Brute Force / Recursive):
// 1. Maintain a global counter 'count' to track steps.
// 2. At each recursion:
//      - If n == 0 → return count
//      - If even → call even(n)
//      - If odd  → call odd(n)
// 3. Reset count at the start of numberOfSteps() so each input is fresh.
//
// Time Complexity: O(log n)
// Space Complexity: O(log n) → recursion stack
//

import java.util.Scanner;

public class Number_Of_Steps_To_Reduce_A_Number_To_0 {

    // GLOBAL for brute-force recursion
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("\nChoose method:");
        System.out.println("1-> Brute Force (Recursive)");
        System.out.println("2-> Optimized (Iterative)");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        int result;
        if (choice == 1) {
            result = numberOfStepsBrute(num);
        } else {
            result = numberOfStepsBest(num);
        }

        System.out.println("\nSteps required: " + result);
    }

    // BRUTE FORCE 
    public static int numberOfStepsBrute(int num) {
        // count = 0; // reset for new test ->only needed for leetcode coz there multiple test cases in one run
        return steps(num);
    }

    static int steps(int n) {
        if (n == 0) return count;

        if (n % 2 == 0) return even(n);
        else return odd(n);
    }

    static int even(int n) {
        n /= 2;
        count++;
        return steps(n);
    }

    static int odd(int n) {
        n -= 1;
        count++;
        return steps(n);
    }

    // BEST SOLUTION (iterative)
    public static int numberOfStepsBest(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }

        return steps;
    }
}


/*
 * PLACEMENT ARRAY 1
 * RotateMatrix.java
 * LeetCode 48: Rotate Image
 * Problem link: https://leetcode.com/problems/rotate-image/
 *
 * Core Logic:
 * 1. Transpose the matrix: swap matrix[i][j] with matrix[j][i]. This converts rows into columns.
 *    - We only swap for j >= i because swapping all elements would undo previous swaps.
 *      For example, swapping (0,1) with (1,0) and later swapping (1,0) with (0,1) reverses it.
 *    - Hence, loop j starts from i, and i starts from 0.
 * 2. Reverse each row:
 *    - Swap elements from left to right until the middle of the row.
 *    - Loop runs j from 0 to n/2 - 1.
 *    - We swap matrix[i][j] with matrix[i][n-1-j].
 *      - `n-1-j` is used to get the mirror index from the right side.
 *      - `n/2` ensures we swap only the first half; swapping past the middle would undo changes.
 *
 * Time Complexity: O(n^2)
 * - Transpose visits each element once, O(n^2)
 * - Reversing rows visits each element once, O(n^2)
 * - Total: O(n^2)
 *
 * Space Complexity: O(1)
 * - In-place rotation; no extra 2D array is used.
 *
 * Things to remember:
 * - The transpose step only swaps the upper triangle with the lower triangle to avoid double-swaps.
 * - While reversing, j goes only till n/2 because after that, elements would be swapped back.
 * - Using n-1-j gets the correct mirror element from the right side.
 */


//I have beautified the code by adding extra etxra form my future revision
import java.util.Scanner;
public class RotateImage_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the matrix (n x n):");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("Rotated Matrix (90 degrees clockwise):");
        printMatrix(matrix);

    }

    // Function to rotate the matrix by 90 degrees clockwise
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (rows become columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // j = i to avoid double-swapping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) { // j < n/2 to only swap first half
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j]; // n-1-j gets the mirror index from right
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Helper to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    
}
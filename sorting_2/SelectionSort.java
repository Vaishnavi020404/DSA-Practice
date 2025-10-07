// for (j = 0; j < n-1; j++)

//     int iMin = j;

//     for (i = j+1; i < n; i++)
//         if (a[i] < a[iMin])
//             iMin = i;

//     if (iMin != j)
//         swap(a[j], a[iMin]);

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter the number of unsorted array elements: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // --------- Choose one of the sorting methods ---------

        // Iterative Selection Sort
        // selectionSortIterative(arr);

        // Recursive Selection Sort
        selectionSortRecursive(arr, 0);

        // -----------------------------------------------------

        System.out.println("Sorted array elements: " + Arrays.toString(arr));
    }

    // Iterative version
    static void selectionSortIterative(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Recursive version
    static void selectionSortRecursive(int[] arr, int start) {
        int n = arr.length;
        if (start >= n - 1) return; // base case: 1 element left

        int minIndex = start;
        for (int j = start + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Swap
        if (minIndex != start) {
            int temp = arr[start];
            arr[start] = arr[minIndex];
            arr[minIndex] = temp;
        }

        // Recurse for the remaining subarray
        selectionSortRecursive(arr, start + 1);
    }
}

// 🏆 Selection Sort

// How it works:

// Divide array into sorted and unsorted parts.

// Find the minimum element in the unsorted part.

// Swap it with the first element of unsorted part.

// After each pass → one element is fixed in its correct position.

// Example:
// Unsorted: 5 3 8 4
// Step1 → 3 5 8 4 (3 placed first)
// Step2 → 3 4 8 5 (4 placed second)
// Step3 → 3 4 5 8 (sorted)

// Why “Selection”?

// Because we select the minimum each time.

// Complexity:

// Best/Average/Worst: O(n²)

// Space: O(1)

// Not stable ❌

// Not adaptive ❌

// Few swaps (n-1 max)

// Advantages: Very simple, fewer swaps.
// Disadvantages: Always O(n²), not stable.
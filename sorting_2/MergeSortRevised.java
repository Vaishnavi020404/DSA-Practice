// mergeSort([5,2,4,3])
// ├── split into [5,2] and [4,3]
// │   ├── mergeSort([5,2])
// │   │   ├── split into [5] and [2]
// │   │   │   ├── mergeSort([5]) -> [5] (base case)
// │   │   │   └── mergeSort([2]) -> [2] (base case)
// │   │   └── merge([5], [2]) -> [2,5]
// │   └── mergeSort([4,3])
// │       ├── split into [4] and [3]
// │       │   ├── mergeSort([4]) -> [4]
// │       │   └── mergeSort([3]) -> [3]
// │       └── merge([4],[3]) -> [3,4]
// └── merge([2,5], [3,4]) -> [2,3,4,5]


// 1. mergesort (The Recursive Function)
// Job: This function is responsible for splitting the array and handling the recursion.

// What it does: It takes a large, unsorted array, checks if it's small enough (base case, n=1), and if not, it continually cuts the array in half until every sub-array has only one element (which is trivially sorted).

// 2. merge (The Helper/Combining Function)
// Job: This function is responsible for combining (or merging) two separate, already-sorted arrays into a single, larger sorted array.

// What it does: It takes two sorted arrays (array a and array b) and efficiently builds the final sorted array (array c) by repeatedly comparing the first elements of a and b and moving the smaller one to the new array.
// Merge Sort Algorithm
// mergesort ( array a )
// if ( n == 1 )
//     return a

// arrayOne = a[0] ... a[n/2]
// arrayTwo = a[n/2+1] ... a[n]

// arrayOne = mergesort ( arrayOne )
// arrayTwo = mergesort ( arrayTwo )

// return merge ( arrayOne, arrayTwo )
// Merge Function
// merge ( array a, array b )
// array c
// while ( a and b have elements )
//     if ( a[0] > b[0] )
//         add b[0] to the end of c
//         remove b[0] from b
//     else
//         add a[0] to the end of c
//         remove a[0] from a

// // At this point either a or b is empty

// while ( a has elements )
//     add a[0] to the end of c
//     remove a[0] from a

// while ( b has elements )
//     add b[0] to the end of c
//     remove b[0] from b

// return c

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortRevised {
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

        // Perform Merge Sort
        arr = mergeSort(arr);
        System.out.println("Sorted array elements: " + Arrays.toString(arr));
    }
    static int[] mergeSort(int[] arr){
        if(arr.length<=1) return arr;
        int mid = arr.length/2;
        int[] left=Arrays.copyOfRange(arr, 0, mid);
        int[] right=Arrays.copyOfRange(arr, mid, arr.length);
        left=mergeSort(left);
        right=mergeSort(right);
        return merge(left,right);

    }

static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;

    // Merge the two arrays
    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            result[k++] = left[i++];
        } else {
            result[k++] = right[j++];
        }
    }

    // Copy remaining elements from left
    while (i < left.length) {
        result[k++] = left[i++];
    }

    // Copy remaining elements from right
    while (j < right.length) {
        result[k++] = right[j++];
    }

    return result;
}

    }




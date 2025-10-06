import java.util.*;
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("Enter the number of unsorted array elements: ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // arr=BubbleSort(arr);
        arr=bubbleSortRecursive(arr, n);

        System.out.println("Sorted array elements: "+ Arrays.toString(arr));

    }

        static int[] bubbleSortRecursive(int[] arr, int n) {
            // Base case: If the array size is 1, it's already sorted
            if (n == 1) {
                return arr;
            }

            // One pass of bubble sort. After this pass, the largest element is moved to the end.
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i+1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            // Recursive call for the remaining array
            return bubbleSortRecursive(arr, n - 1);
        }
        // static int[] BubbleSort(int[] arr){
        //     int n=arr.length;
        //     for(int i=0;i<n-1;i++){
        //         for(int j=0;j<n-1;j++){
        //             if(arr[j]>arr[j+1]){
        //                 int temp=arr[j];
        //                 arr[j]=arr[j+1];
        //                 arr[j+1]=temp;
        //             }
        //         }
        //     }
        //     return arr;
        // }
}


// NOTES:
// 1. How Bubble Sort Works (Iterative/Non-Recursive Version)
// Bubble Sort repeatedly compares adjacent elements in an array.
// If the current element is greater than the next, they are swapped.
// After one full pass, the largest element “bubbles up” to the end of the array.
// Each subsequent pass ignores the last element(s) already in place because they’re already sorted.
// This process repeats until the array is completely sorted.

// Example:

// Unsorted: 5 3 8 4
// Pass 1: 3 5 4 8  -> 8 is in correct place
// Pass 2: 3 4 5 8  -> 5 is in correct place
// Pass 3: 3 4 5 8  -> Array sorted


// ✅ Notice that after each iteration, the last element is automatically in the correct position. That’s a key feature of Bubble Sort.

// 3. Time & Space Complexity:
// Best Case: O(n) (array already sorted, with optimized version)
// Worst/Average Case: O(n²)
// Space: O(1) iterative, O(n) recursion (stack memory)
// 4. Advantages:
// Simple, easy to implement.
// Good for small datasets or mostly sorted arrays.
// 5. Disadvantages:
// Slow for large arrays.
// Not memory-efficient in recursion for very large arrays.

// Key Characteristics:
// In-Place Sorting: Requires only a constant amount of additional memory space.
// Stable Sort: Maintains the relative order of records with equal keys.
// Adaptive: Can be optimized to stop early if the list becomes sorted before completing all passes.


// 2. Why is it called 'Bubble Sort'?
// The algorithm is named "Bubble Sort" because smaller elements "bubble" to the top of the array (beginning), while larger elements "sink" to the bottom (end) with each pass.


// Why the largest element “bubbles” to the end:

// Each time Bubble Sort compares two adjacent elements, the larger one moves one step right if it’s bigger than its neighbor.
// By repeatedly doing this across the array, the largest element keeps moving right until it reaches the last position.
// “In Bubble Sort, the largest element ‘bubbles’ to the end because each comparison pushes bigger elements one step right until they reach their correct position."
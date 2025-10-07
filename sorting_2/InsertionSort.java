// for i : 1 to length(A) - 1
//     j = i
//     while j > 0 and A[j-1] > A[j]
//         swap A[j] and A[j-1]
//         j = j - 1
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
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
        arr=insertionSort(arr, n);

        System.out.println("Sorted array elements: "+ Arrays.toString(arr));

    }
    static int[] insertionSort(int[] arr,int n){
        for(int i=1;i<n;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        return arr;
    }
}

// Dry Run Step by Step:
// Iteration 1: i = 1, j = 1

// arr = [5, 3, 4, 1, 2]

// Compare arr[1]=3 with arr[0]=5 → 3 < 5 ✅

// Swap → [3, 5, 4, 1, 2]

// Decrement j=0 → loop stops (j > 0 fails).

// Iteration 2: i = 2, j = 2

// arr = [3, 5, 4, 1, 2]

// Compare arr[2]=4 with arr[1]=5 → 4 < 5 ✅

// Swap → [3, 4, 5, 1, 2]

// Now j=1.

// Compare arr[1]=4 with arr[0]=3 → 4 < 3 ❌ → stop.

// Iteration 3: i = 3, j = 3

// arr = [3, 4, 5, 1, 2]

// Compare arr[3]=1 with arr[2]=5 → 1 < 5 ✅ → swap → [3, 4, 1, 5, 2]

// j=2 → Compare arr[2]=1 with arr[1]=4 → 1 < 4 ✅ → swap → [3, 1, 4, 5, 2]

// j=1 → Compare arr[1]=1 with arr[0]=3 → 1 < 3 ✅ → swap → [1, 3, 4, 5, 2]

// j=0 → stop.

// Iteration 4: i = 4, j = 4

// arr = [1, 3, 4, 5, 2]

// Compare arr[4]=2 with arr[3]=5 → 2 < 5 ✅ → swap → [1, 3, 4, 2, 5]

// j=3 → Compare arr[3]=2 with arr[2]=4 → 2 < 4 ✅ → swap → [1, 3, 2, 4, 5]

// j=2 → Compare arr[2]=2 with arr[1]=3 → 2 < 3 ✅ → swap → [1, 2, 3, 4, 5]

// j=1 → Compare arr[1]=2 with arr[0]=1 → 2 < 1 ❌ → stop.

// 🪪 Insertion Sort

// How it works:

// Think of sorting cards in your hand.

// Pick the next element, compare it with left elements, and shift them until it finds its correct place.

// After each step → left side is sorted.

// Example:
// Unsorted: 5 3 4 1
// Step1 → 3 5 4 1
// Step2 → 3 4 5 1
// Step3 → 1 3 4 5 (sorted)

// Why “Insertion”?

// Because we insert each element into the sorted subarray at its right position.

// Complexity:

// Best Case: O(n) (already sorted)

// Average/Worst Case: O(n²)

// Space: O(1)

// Stable ✅

// Adaptive ✅

// Advantages: Efficient for small/partially sorted arrays, easy to code.
// Disadvantages: Slow for large datasets.

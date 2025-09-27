package Sorting_2;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

    }

    public static int partition(int[] arr,int low,int high){
        int pivot = arr[low]; // pivot value
        int i=low;
        int j=high;
        while(i<j){
            
while(arr[i] <= pivot && i < high) i++;
while(arr[j] > pivot && j > low) j--;

            
if (i < j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

            
        }
        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
        

}



// # QuickSort Partition Notes (Hoare Scheme)

// ### 1️⃣ Pivot Concept

// * Choose a **pivot value** (usually first element).
// * Goal: put numbers **smaller than pivot on the left**, numbers **greater than pivot on the right**.
// * Pivot itself will end up in its **final sorted position** after partition.

// ---

// ### 2️⃣ i and j “walking pointers”

// * `i` starts at **left**, `j` starts at **right**.
// * Move `i` to the right until you find a number **> pivot**.
// * Move `j` to the left until you find a number **≤ pivot**.

// ```java
// while(arr[i] <= pivot && i < high) i++;
// while(arr[j] > pivot && j > low) j--;
// ```

// * After these moves, `i` and `j` may have **crossed each other**.

// ---

// ### 3️⃣ Why `if(i < j)` is needed

// * Example:

// ```
// i points at index 3
// j points at index 2
// ```

// * They **crossed**, but outer `while(i < j)` has not stopped.
// * **If you swap now**, you swap numbers that are **already on the correct side** → array gets messed up.
// * **Solution:** Swap only if `i < j`.

// ```java
// if(i < j) {
//     int temp = arr[i];
//     arr[i] = arr[j];
//     arr[j] = temp;
// }
// ```

// ✅ Only swap when safe.

// ---

// ### 4️⃣ Key idea in one sentence

// > Outer `while(i < j)` = keep walking
// > Inner `if(i < j)` = swap only if pointers haven’t crossed

// ---

// ### 5️⃣ Summary of Steps

// 1. Pick pivot.
// 2. Move `i` and `j` until numbers on the wrong side are found.
// 3. Swap `arr[i]` and `arr[j]` **only if i < j**.
// 4. Repeat until `i >= j`.
// 5. Swap pivot into position (`arr[j]`).
// 6. Recursively sort left and right parts.


// Notes: while and if in Hoare Partition
// 1️⃣ Outer while(i < j) loop

// Purpose: keep moving i and j toward each other until they meet or cross.

// As long as i < j, the partition process continues.

// Inside this loop:

// while(arr[i] <= pivot && i < high) i++; // i moves right
// while(arr[j] > pivot && j > low) j--;  // j moves left


// These inner loops move i and j to numbers that are on the wrong side.

// 2️⃣ Why we need if(i < j) before swapping

// After moving i and j, they may cross each other at this step.

// If we swap anyway, we swap numbers that are already on correct sides, breaking the array.

// The if(i < j) check ensures we swap only when it’s safe:

// if(i < j) {
//     swap(arr[i], arr[j]);
// }

// 3️⃣ Simple analogy

// i = person walking right, j = person walking left.

// Stop when they find numbers that “don’t belong” on their side.

// Swap them if they haven’t bumped into each other.

// Outer while = “keep walking until they meet.”

// Inner if = “swap only if safe.”

// 4️⃣ Key points

// Outer while: controls the partitioning process.

// Inner if: prevents a wrong swap when pointers cross.

// Without the inner if → final step can mess up the array.

// 💡 Memory trick:

// Think: while = walk, if = check before touching.
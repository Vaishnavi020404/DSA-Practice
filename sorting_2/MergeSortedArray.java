//===========================================================
// LeetCode 88 - Merge Sorted Array
// Date: 27/09/2025
// Link: https://leetcode.com/problems/merge-sorted-array/
// Tags: Array / Two Pointers / In-place
// Approach: 
//   1) Merge nums2 into nums1 in-place starting from the end to avoid overwriting.
//   2) Use three pointers: i (end of nums1’s valid part), j (end of nums2), k (end of nums1 array).
// Time Complexity: O(m + n)
// Space Complexity: O(1)
//===========================================================

import java.util.Scanner;

public class MergeSortedArray {

    //===========================================================
    // Main method - Input / Processing / Output
    //===========================================================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the size of nums1 and nums2:");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        System.out.println("Enter nums1 elements (first " + m + " valid,and assume rest will be 0s):");
        for (int i = 0; i < m; i++) nums1[i] = sc.nextInt();

        System.out.println("Enter nums2 elements:");
        for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();

        //--------------- Processing Section ----------------
        merge(nums1, m, nums2, n);

        //--------------- Output Section ----------------
        System.out.println("Merged Sorted Array:");
        for (int num : nums1) System.out.print(num + " ");

        sc.close();
    }

    //===========================================================
    // Merge Function - In-place merge from the end
    //===========================================================
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last valid element in nums1
        int j = n - 1;       // last element in nums2
        int k = m + n - 1;   // last index of nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

// Ahhh, now this is the subtle part that confuses a lot of people 😅 — let me explain carefully.

// ---

// ### **Why `i` (nums1) usually exhausts first in backward merge**

// Remember:

// * `nums1`’s first `m` elements are **already sorted and generally bigger** in normal merge examples.
// * `nums2`’s elements are the ones we are trying to insert.

// When we merge **from the end**:

// 1. We always **pick the larger of nums1[i] and nums2[j]** and put it at `nums1[k]`.
// 2. nums1[i] is already at the **end of its valid section**, so if it’s bigger than nums2[j], it goes to the very end.
// 3. nums2[j] only moves when it’s bigger than nums1[i] or nums1[i] has been placed.

// ---

// ### **Key idea**

// * The **backward merge ensures the largest numbers are placed first**.
// * That means the **big numbers of nums1** get placed at the end immediately.
// * Once all these bigger nums1 numbers are placed, `i` can reach `-1` before `j` reaches `-1` **only if nums2 has smaller numbers left**.

// ---

// ### **Example where i exhausts first**

// ```java
// nums1 = [2,5,7,0,0], m = 3
// nums2 = [1,3], n = 2
// ```

// Step by step backward merge:

// | nums1[i] | nums2[j] | Placed at nums1[k] | nums1 after | i  | j | k |
// | -------- | -------- | ------------------ | ----------- | -- | - | - |
// | 7        | 3        | nums1[4] = 7       | [2,5,7,0,7] | 1  | 1 | 3 |
// | 5        | 3        | nums1[3] = 5       | [2,5,7,5,7] | 0  | 1 | 2 |
// | 2        | 3        | nums1[2] = 3       | [2,5,3,5,7] | 0  | 0 | 1 |
// | 2        | 1        | nums1[1] = 2       | [2,2,3,5,7] | -1 | 0 | 0 |

// ✅ i exhausted first (i = -1), but j still has 1 left → we just copy it into nums1[0].

// ---

// ### **When j exhausts first**

// * If nums2’s largest number is **bigger than all nums1 numbers**, j will exhaust first.
// * Example:

// ```java
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [4,5,6], n = 3
// ```

// * Here, nums2’s largest numbers are bigger → they get placed at the end, j exhausts first.
// * i still points to nums1 leftovers → which are **already in the correct place**, so no copying needed.

// ---

// ### **TL;DR**

// * **i doesn’t always exhaust first** — it depends on the numbers.
// * Backward merge works **regardless**:

//   * If i > j → only nums2 leftovers copied
//   * If j > i → only nums1 leftovers remain → already sorted

// ---

// If you want, I can make a **super simple visual table showing both scenarios side by side** so you’ll literally “see” when i or j exhausts first.

// Do you want me to do that?

// --------------------------------
// // Forward merge attempt (why it fails)

// // You start at the front of nums1

// // Compare nums1[0] and nums2[0] → 4 vs 1

// // You want to put smaller first → write 1 into nums1[0]

// // nums1 = [1, 5, 6, 0, 0, 0]  // 4 is gone! 😱


// // Uh-oh! You just destroyed 4 before even moving it anywhere

// // Next, you try to put 2 in nums1[1], destroy 5…

// // Everything breaks

// // Forward merge = overwriting important numbers 🔥

// // Backward merge (why it works)

// // Start at the end of nums1 (last empty spot)

// // Compare last valid of nums1 (6) and last of nums2 (3)

// // Bigger one goes at the last spot → nums1[5] = 6

// // nums1 = [4, 5, 6, 0, 0, 6]  // safe! we didn’t destroy anything


// // Move pointers backward, keep putting bigger numbers in the empty/back spots

// // Done! Everything fits perfectly

// // Backward merge = safe, no overwriting ✅

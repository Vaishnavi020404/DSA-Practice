//===========================================================
// LeetCode 88 - Merge Sorted Array
// Date: 08/10/2025
// Link: https://leetcode.com/problems/merge-sorted-array/
// Tags: Array, Two Pointers
// Approach 1 (Inefficient):
//   Copy nums2 into nums1 and sort the entire array (O((m+n)log(m+n)))
// Approach 2 (Optimal):
//   Use two pointers from the end and fill nums1 in place (O(m+n))
//===========================================================

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrayResolved {

    //-------------------------- Approach 1 ----------------------------
    // Copy nums2 into nums1 and sort (inefficient)
    public static void mergeWithSort(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0; j < n; j++) {
            nums1[m + j] = nums2[j];
        }
        Arrays.sort(nums1);
        System.out.println("After mergeWithSort (inefficient): " + Arrays.toString(nums1));
    }

    //-------------------------- Approach 2 ----------------------------
    // Optimal two-pointer merge from the end
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;        // Pointer for nums1
        int p2 = n - 1;        // Pointer for nums2
        int p = m + n - 1;     // Pointer for placing elements in nums1

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        System.out.println("After mergeOptimal (efficient): " + Arrays.toString(nums1));
    }

    //-------------------------- Main Method ----------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of nums2 (n)
        System.out.print("Enter the number of elements in nums2 (n): ");
        int n = sc.nextInt();
        int[] nums2 = new int[n];
        System.out.println("Enter elements of nums2(enter sorted numbers):");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        // Input size of nums1 (actual elements m)
        System.out.print("Enter the number of elements in nums1 (m) excluding 0s(enter sorted numbers): ");
        int m = sc.nextInt();

        int[] nums1 = new int[m + n]; 
        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }



        // Copy nums1 for comparison
        int[] nums1Copy = Arrays.copyOf(nums1, m + n);

        // Call inefficient method
        mergeWithSort(nums1Copy, m, nums2, n);

        // Call optimal method
        mergeOptimal(nums1, m, nums2, n);

        sc.close();
    }
}

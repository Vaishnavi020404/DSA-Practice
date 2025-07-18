// LeetCode Problem: 88. Merge Sorted Array
// Link: https://leetcode.com/problems/merge-sorted-array/
// Approach: Manual Two-Step Process (Appending + Sorting)
// Time Complexity: O((m + n)^2) - because of nested loops used for sorting
// Space Complexity: O(1) - in-place sorting, no extra arrays used

// ✅ Notes:
// 1. First, I appended nums2 into nums1 from index m onwards.
// 2. Then, I sorted nums1 using nested loops.
// 3. Realized: For merge problems, appending is correct, but sorting using nested loops is inefficient. Sorting should ideally be O(m + n).
// 4. This method is acceptable for learning, but in interviews, they expect O(m + n) merge using two pointers, without nested loops.

// ## ✅ Reverse Sorted Approach Summary:
// - Use 3 pointers from the end:
//   - `p1 = m - 1` → last number in nums1’s valid part
//   - `p2 = n - 1` → last number in nums2
//   - `p = m + n - 1` → last total position in nums1

// - **While `p2 >= 0`:**
//   - If `nums1[p1] > nums2[p2]`: place `nums1[p1]` at `nums1[p]`, move `p1--`.
//   - Else: place `nums2[p2]` at `nums1[p]`, move `p2--`.
//   - Always move `p--` after placing.

// - ✅ Time: O(m + n)  
// - ✅ Space: O(1) (In-place)

//BASICLALY MY APPROACH WAS MERGING FIRST AND THEN SORTING AND THE OPTIMIZED APPROACH WAS DOING BOTH SIMLUTANOEUSLY

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n=3;
        merge(nums1, m, nums2, n);
        // optimizedMerge(nums1, m, nums2, n);        
        System.out.println(Arrays.toString(nums1));

    }

        //brute force method that I could think of
        static int[] merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m, j = 0; i < nums1.length && j < n; i++, j++) {
                nums1[i] = nums2[j];
            }


            for(int i=0;i<nums1.length;i++){
                for(int j=i+1;j<nums1.length;j++){
                    if(nums1[i]>nums1[j]){
                        int temp=nums1[i];
                        nums1[i]=nums1[j];
                        nums1[j]=temp;
                    }
                }
            }  
            return nums1;
        }

        //Optimized solution - Reverse Two pointer mehtod 
        static int[] optimizedMerge(int[] nums1, int m, int[] nums2, int n){
            int p1=m-1;
            int p2=n-1;
            int p=m+n-1;
            while(p2>=0){
                if(p1>=0 && nums1[p1]>nums2[p2]){
                    nums1[p]=nums1[p1];
                    p1--;
                }else{
                    nums1[p]=nums2[p2];
                    p2--;
                }
                p--;
            }
            return nums1;

        }

    
}


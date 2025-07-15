// ✅ LeetCode Problem: 75. Sort Colors
// Link: https://leetcode.com/problems/sort-colors/
// Approach 1: Counting Method (Your Current Solution)
// - Time Complexity: O(n) (2 passes)
// - Space Complexity: O(1) extra space (c0, c1, c2 counters)
// ✅ What to remember:
// - Counting method is simple and intuitive.
// - Suitable when in-place sorting in one pass is not strictly required.

// Approach 2: Dutch National Flag Algorithm (Optimized)
// - Time Complexity: O(n) (Single pass)
// - Space Complexity: O(1) extra space
// ✅ What to remember:
// - Use three pointers: low, mid, high.
// - low: points where next 0 should go.
// - mid: current element under consideration.
// - high: points where next 2 should go.
// - Ideal when interviewer asks for one-pass in-place sort with constant space.


import java.lang.*;
import java.util.*;

public class SortColours {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.err.println("Enter the size of the array: ");
        int n=sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter the elements of the array containing random numbers(0,1,2 only) : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }    

        sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }   
    static void sortColors(int[] nums) {
        int c0=0;
        int c1=0;
        int c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c0++;
            }
            if(nums[i]==1){
                c1++;
            }
            if(nums[i]==2){
                c2++;
            }
        }
        
        for(int j=0;j<c0;j++){
            nums[0+j]=0;
        }
        for(int k=0;k<c1;k++){
            nums[c0+k]=1;
        }
        for(int l=0;l<c2;l++){
            nums[c1+c0+l]=2;
        }        
    } 
}

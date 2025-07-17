// /*
// LeetCode Problem: 922. Sort Array By Parity II  
// Link: https://leetcode.com/problems/sort-array-by-parity-ii/  
// Approach: Two Pointer (One for even indices, one for odd indices)  
// Time Complexity: O(n)  
// Space Complexity: O(1)  

// ------------------------------
// Notes:

// - What was wrong before:
//   I was only checking one side (even or odd) in my loop and trying to swap with the last element.  
//    That doesn’t guarantee both even-index and odd-index placement are fixed properly.  
//    I didn’t maintain two separate pointers for even and odd positions.

// - New Approach:
//    Use two pointers:  
//     1. `even` pointer starts at index 0, moves by +2 each step.  
//     2. `odd` pointer starts at index 1, moves by +2 each step.  
//    If `nums[even]` is odd and `nums[odd]` is even, swap them.  
//    Guaranteed to work because the array has equal even and odd numbers.

import java.util.Arrays;
import java.util.Scanner;


public class SortByParity2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter an array with half of the integers in nums are odd, and the other half are even: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        paritycheck2(arr);
        System.out.println(Arrays.toString(arr));

    }    
     static int[] paritycheck2(int[]nums) {
        int evenIndex=0;
        int oddIndex=1;
        int n=nums.length;

        while(evenIndex<n && oddIndex<n){
            if(nums[evenIndex]%2==0){
                evenIndex+=2;
            }
            else if(nums[oddIndex]%2!=0){
                oddIndex+=2;
            }else{
                int temp=nums[oddIndex];
                nums[oddIndex]=nums[evenIndex];
                nums[evenIndex]=temp;
                evenIndex+=2;
                oddIndex+=2;
            }

        }


        return nums;  
        

    }
    
}


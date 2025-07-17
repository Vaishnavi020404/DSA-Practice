// LeetCode Problem: 283. Move Zeroes  
// Link: https://leetcode.com/problems/move-zeroes/  
// Approach: Two Pointer Approach  
// Time Complexity: O(n) — Single pass through the array  
// Space Complexity: O(1) — In-place operation  

/*  
Notes:  
- First, maintain a pointer (insertPos) starting at index 0.  
- Move non-zero elements to the front by overwriting.  
- After processing all elements, fill the remaining slots with zero.  
- Key learning:  
  → Avoid unnecessary swaps; just overwrite values.  
  → InsertPos should iterate till nums.length, not nums.length - 1, otherwise last index won’t be updated.  
  → Two pointer helps when order matters and in-place modification is required.  
*/


import java.util.Arrays;
import java.util.Scanner;
public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));


}
    static int[] moveZeroes(int[] nums) {
    int insertPosition=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[insertPosition]=nums[i];
            insertPosition++;
        }
    }
    while(insertPosition<nums.length){
        nums[insertPosition]=0;
        insertPosition++;
    }    
    return nums;
    }
}
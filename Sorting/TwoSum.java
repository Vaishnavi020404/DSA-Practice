// LeetCode 1 — Two Sum (Brute Force Approach)
// Problem Link: https://leetcode.com/problems/two-sum/
// Approach: Brute Force using Two Nested Loops
// Time Complexity: O(n²)
// Space Complexity: O(1)
// Note: HashMap-based O(n) solution exists, but I haven't learned HashMaps yet.



import java.util.Arrays;
import java.util.Scanner;
public class TwoSum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target value: ");
        int target=sc.nextInt();
        arr=twoSum(arr,target);
        System.out.println(Arrays.toString(arr));

    }



        static int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
     
        for(int left=0;left<=nums.length-2;left++){
            for(int right=left+1;right<=nums.length-1;right++){
                if(nums[left]+nums[right]==target){
                    ans[0]=left;
                    ans[1]=right;
                }
            }
            
        }return ans;
        
    }
    
}

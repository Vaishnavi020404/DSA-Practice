// LeetCode Problem: 448. Find All Numbers Disappeared in an Array
// Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Contains:
// ✅ Optimized Cyclic Sort Approach: O(n) Time, O(1) Extra Space(ignoring the result list)
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisappearedNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of array (n): ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (numbers from 1 to n, missing one number):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("The Disappeared Numbers are " + findDisappearedNumbers(nums));
    
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                int temp=nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=temp;
            }else{
                i++;
            }
        }

        List<Integer> ans=new ArrayList<>();
        int j=0;
        while(j<nums.length){
            if(nums[j]!=j+1){
                ans.add(j+1);
                j++;
            }else{
                j++;
            }
        }
        return ans;
    }
    

}
